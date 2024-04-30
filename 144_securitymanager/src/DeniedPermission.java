import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.security.BasicPermission;
import java.security.Permission;
import java.security.UnresolvedPermission;
import java.text.MessageFormat;

/**
 * A representation of a "negative" privilege.
 * <p>
 * A <code>DeniedPermission</code>, when "granted" (to some
 * <code>ProtectionDomain</code> and/or
 * <code>Principal</code>), represents a privilege which <em>cannot</em> be
 * exercised, regardless of
 * any positive permissions (<code>AllPermission</code> included) possessed. In
 * other words, if a
 * set of granted permissions, <em>P</em>, contains a permission of this class,
 * <em>D</em>, then the
 * set of effectively granted permissions is<br/>
 * <br/>
 * &nbsp;&nbsp;&nbsp;&nbsp;<em>{ P<sub>implied</sub> - D<sub>implied</sub>
 * }</em>.
 * </p>
 * <p>
 * Each instance of this class encapsulates a <em>target permission</em>,
 * representing the
 * "positive" permission being denied.
 * </p>
 * Denied permissions employ the following naming scheme:<br/>
 * <br/>
 *
 * &nbsp;&nbsp;&nbsp;&nbsp;<em>&lt;target_class_name&gt;:&lt;target_name&gt;(:&lt;target_actions&gt;)</e
 * m><br/>
 * <br/>
 * where:
 * <ul>
 * <li><em>target_class_name</em> is the name of the target permission's
 * class,</li>
 * <li><em>target_name</em> is the name of the target permission, and</li>
 * <li><em>target_actions</em> is, optionally, the actions string of the target
 * permission.</li>
 * </ul>
 * A denied permission, having a target permission <em>t</em>, is said to
 * <em>imply</em> another
 * permission <em>p</em>, if:
 * <ul>
 * <li>p <em>is not</em> itself a denied permission, and
 * <code>(t.implies(p) == true)</code>,
 * or</li>
 * <li>p <em>is</em> a denied permission, with a target <em>t1</em>, and
 * <code>(t.implies(t1) == true)</code>.
 * </ul>
 * <p>
 * It is the responsibility of the policy decision point (e.g., the
 * <code>Policy</code> provider) to
 * take denied permission semantics into account when issuing authorization
 * statements.
 * </p>
 */
public final class DeniedPermission extends BasicPermission {
    private final Permission target;
    private static final long serialVersionUID = 473625163869800679L;

    /**
     * Instantiates a <code>DeniedPermission</code> that encapsulates a target
     * permission of the
     * indicated class, specified name and, optionally, actions.
     *
     * @throws IllegalArgumentException
     *             if:
     *             <ul>
     *             <li><code>targetClassName</code> is <code>null</code>, the empty
     *             string, does not
     *             refer to a concrete <code>Permission</code> descendant, or refers
     *             to
     *             * <code>DeniedPermission.class</code> or
     *             <code>UnresolvedPermission.class</code>.</li>
     *             <li><code>targetName</code> is <code>null</code>.</li>
     *             <li><code>targetClassName</code> cannot be instantiated, and it's
     *             the caller's
     *             fault;
     *             e.g., because <code>targetName</code> and/or
     *             <code>targetActions</code> do not
     *             adhere
     *             to the naming constraints of the target class; or due to the
     *             target class not
     *             exposing a <code>(String name)</code>, or
     *             <code>(String name, String
    actions)</code>
     *             constructor, depending on whether <code>targetActions</code> is
     *             <code>null</code>
     *             or
     *             not.</li>
     *             </ul>
     */
    public static DeniedPermission newDeniedPermission(String targetClassName, String targetName,
            String targetActions) {
        if (targetClassName == null || targetClassName.trim().isEmpty() || targetName == null) {
            throw new IllegalArgumentException(
                    "Null or empty [targetClassName], or null [targetName] argument was supplied.");
        }
        StringBuilder sb = new StringBuilder(targetClassName).append(":").append(targetName);
        if (targetName != null) {
            sb.append(":").append(targetName);
        }
        return new DeniedPermission(sb.toString());
    }

    /**
     * Instantiates a <code>DeniedPermission</code> that encapsulates a target
     * permission of the
     * class,
     * name and, optionally, actions, collectively provided as the <code>name</code>
     * argument.
     *
     * @throws IllegalArgumentException
     *             if:
     *             <ul>
     *             <li><code>name</code>'s target permission class name component is
     *             empty, does not
     *             refer to a concrete <code>Permission</code> descendant, or refers
     *             to
     *             <code>DeniedPermission.class</code> or
     *             <code>UnresolvedPermission.class</code>.</li>
     *             <li><code>name</code>'s target name component is
     *             <code>empty</code></li>
     *             <li>the target permission class cannot be instantiated, and it's
     *             the caller's
     *             fault;
     *             e.g., because <code>name</code>'s target name and/or target
     *             actions component(s)
     *             do
     *             not adhere to the naming constraints of the target class; or due
     *             to the target
     *             class
     *             not exposing a <code>(String name)</code>, or
     *             <code>(String name, String actions)</code> constructor, depending
     *             on whether the
     *             target actions component is empty or not.</li>
     *             </ul>
     */
    public DeniedPermission(String name) {
        super(name);
        String[] comps = name.split(":");
        if (comps.length < 2) {
            throw new IllegalArgumentException(MessageFormat.format("Malformed name [{0}] argument.", name));
        }
        this.target = initTarget(comps[0], comps[1], ((comps.length < 3) ? null : comps[2]));
    }

    /**
     * Instantiates a <code>DeniedPermission</code> that encapsulates the given
     * target permission.
     *
     * @throws IllegalArgumentException
     *             if <code>target</code> is <code>null</code>, a
     *             <code>DeniedPermission</code>, or
     *             an
     *             <code>UnresolvedPermission</code>.
     */
    public static DeniedPermission newDeniedPermission(Permission target) {
        if (target == null) {
            throw new IllegalArgumentException("Null [target] argument.");
        }
        if (target instanceof DeniedPermission || target instanceof UnresolvedPermission) {
            throw new IllegalArgumentException("[target] must not be a DeniedPermission or an UnresolvedPermission.");
        }
        StringBuilder sb = new StringBuilder(target.getClass().getName()).append(":").append(target.getName());
        String targetActions = target.getActions();
        if (targetActions != null) {
            sb.append(":").append(targetActions);
        }
        return new DeniedPermission(sb.toString(), target);
    }

    private DeniedPermission(String name, Permission target) {
        super(name);
        this.target = target;
    }

    private Permission initTarget(String targetClassName, String targetName, String targetActions) {
        Class<?> targetClass;
        try {
            targetClass = Class.forName(targetClassName);
        } catch (ClassNotFoundException cnfe) {
            if (targetClassName.trim().isEmpty()) {
                targetClassName = "<empty>";
            }
            throw new IllegalArgumentException(
                    MessageFormat.format("Target Permission class [{0}] not found.",
                            targetClassName));
        }
        if (!Permission.class.isAssignableFrom(targetClass) ||
                Modifier.isAbstract(targetClass.getModifiers())) {
            throw new IllegalArgumentException(MessageFormat
                    .format("Target Permission class [{0}] is not a (concrete) Permission.",
                            targetClassName));
        }
        if (targetClass == DeniedPermission.class || targetClass == UnresolvedPermission.class) {
            throw new IllegalArgumentException("Target Permission class cannot be a DeniedPermission itself.");
        }
        Constructor<?> targetCtor;
        try {
            if (targetActions == null) {
                targetCtor = targetClass.getConstructor(String.class);
            } else {
                targetCtor = targetClass.getConstructor(String.class, String.class);
            }
        } catch (NoSuchMethodException nsme) {
            throw new IllegalArgumentException(MessageFormat.format(
                    "Target Permission class [{0}] does not provide or expose a (String name) or (String name, String actions) constructor.",
                    targetClassName));
        }
        try {
            return (Permission) targetCtor
                    .newInstance(((targetCtor.getParameterCount() == 1) ? new Object[] { targetName
                    }
                            : new Object[] { targetName, targetActions }));
        } catch (ReflectiveOperationException roe) {
            if (roe instanceof InvocationTargetException) {
                if (targetName == null) {
                    targetName = "<null>";
                } else if (targetName.trim().isEmpty()) {
                    targetName = "<empty>";
                }
                if (targetActions == null) {
                    targetActions = "<null>";
                } else if (targetActions.trim().isEmpty()) {
                    targetActions = "<empty>";
                }
                throw new IllegalArgumentException(MessageFormat.format(
                        "Could not instantiate target Permission class [{0}]; provided target name [{1}] and/or target actions [{2}] potentially erroneous.",
                        targetClassName, targetName, targetActions), roe);
            }
            throw new RuntimeException(
                    "Could not instantiate target Permission class [{0}]; an unforeseen error occurred - see attached cause for details",
                    roe);
        }
    }

    /**
     * Checks whether the given permission is implied by this one, as per the
     * {@link DeniedPermission
     * overview}.
     */
    @Override
    public boolean implies(Permission p) {
        if (p instanceof DeniedPermission) {
            return target.implies(((DeniedPermission) p).target);
        }
        return target.implies(p);
    }

    /**
     * Returns this denied permission's target permission (the actual positive
     * permission which is
     * not
     * to be granted).
     */
    public Permission getTargetPermission() {
        return target;
    }
}
