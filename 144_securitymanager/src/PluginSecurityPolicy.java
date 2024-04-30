import java.security.*;

// Your implementation of SecurityPolicy
class PluginSecurityPolicy extends Policy {
    private final Permissions appPermissions = new Permissions();
    private final Permissions pluginPermissions = new Permissions();

    public PluginSecurityPolicy() {
        // amend this as appropriate
        appPermissions.add(new AllPermission());
        // add any permissions plugins should have to pluginPermissions
    }

    @Override
    public PermissionCollection getPermissions(CodeSource codesource) {
        return new Permissions();
    }

    @Override
    public PermissionCollection getPermissions(ProtectionDomain domain) {
        return isPlugin(domain) ? pluginPermissions : appPermissions;
    }

    private boolean isPlugin(ProtectionDomain pd) {
        return pd.getClassLoader() instanceof PluginClassLoader;
    }
}