import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.File;

public class using_urlclassloader extends Application {
    // Using URLClassLoader/ gunakan URLClassLoader

    /*
     * Ada beberapa cara untuk mengimplementasikan sistem plugin untuk aplikasi
     * Java. Salah satu yang paling sederhana adalah dengan menggunakan
     * URLClassLoader. Contoh berikut akan melibatkan sedikit kode JavaFX.
     * 
     * Misalkan kita memiliki modul aplikasi utama. Modul ini seharusnya memuat
     * plugin dalam bentuk Jars dari
     * folder 'plugin'. Kode awal:
     * 
     * package main;
     * public class MainApplication extends Application
     * {
     * 
     * @Override
     * public void start(Stage primaryStage) throws Exception
     * {
     * File pluginDirectory=new File("plugins"); //arbitrary directory
     * if(!pluginDirectory.exists())pluginDirectory.mkdir();
     * VBox loadedPlugins=new VBox(6); //a container to show the visual info later
     * Rectangle2D screenbounds=Screen.getPrimary().getVisualBounds();
     * Scene scene=new
     * Scene(loadedPlugins,screenbounds.getWidth()/2,screenbounds.getHeight()/2);
     * primaryStage.setScene(scene);
     * primaryStage.show();
     * }
     * public static void main(String[] a)
     * {
     * launch(a);
     * }
     * }
     * 
     */

    // Mari tambahkan HashSet statis ke MainApplication yang akan menampung plugin
    // yang dimuat:

    /*
     * static HashSet<Plugin> plugins=new HashSet<>();
     */

    /*
     * Selanjutnya, kita membuat instance URLClassLoader, dan mengulangi nama kelas,
     * membuat instance kelas yang mengimplementasikan antarmuka Plugin:
     * 
     * URLClassLoader urlClassLoader=new URLClassLoader(urls.toArray(new
     * URL[urls.size()]));
     * classes.forEach(className->{
     * try
     * {
     * Class
     * cls=urlClassLoader.loadClass(className.replaceAll("/",".").replace(".class",
     * ""));
     * //transforming to binary name
     * Class[] interfaces=cls.getInterfaces();
     * for(Class intface:interfaces)
     * {
     * if(intface.equals(Plugin.class)) //checking presence of Plugin interface
     * {
     * Plugin plugin=(Plugin) cls.newInstance(); //instantiating the Plugin
     * plugins.add(plugin);
     * break;
     * }
     * }
     * }
     * catch (Exception e){e.printStackTrace();}
     * });
     */

    /*
     * Lalu, kita bisa memanggil metode plugin, misalnya, untuk menginisialisasinya:
     * if(!plugins.isEmpty())loadedPlugins.getChildren().add(new
     * Label("Loaded plugins:"));
     * plugins.forEach(plugin -> {
     * plugin.initialize();
     * loadedPlugins.getChildren().add(new Label(plugin.name()));
     * });
     */

    // Kode terakhir dari MainApplication
    /*
     * package main;
     * public class MainApplication extends Application
     * {
     * static HashSet<Plugin> plugins=new HashSet<>();
     * 
     * @Override
     * public void start(Stage primaryStage) throws Exception
     * {
     * File pluginDirectory=new File("plugins");
     * if(!pluginDirectory.exists())pluginDirectory.mkdir();
     * File[] files=pluginDirectory.listFiles((dir, name) -> name.endsWith(".jar"));
     * VBox loadedPlugins=new VBox(6);
     * loadedPlugins.setAlignment(Pos.CENTER);
     * if(files!=null && files.length>0)
     * {
     * ArrayList<String> classes=new ArrayList<>();
     * ArrayList<URL> urls=new ArrayList<>(files.length);
     * for(File file:files)
     * {
     * JarFile jar=new JarFile(file);
     * jar.stream().forEach(jarEntry -> {
     * if(jarEntry.getName().endsWith(".class"))
     * {
     * classes.add(jarEntry.getName());
     * }
     * });
     * URL url=file.toURI().toURL();
     * urls.add(url);
     * }
     * URLClassLoader urlClassLoader=new URLClassLoader(urls.toArray(new
     * URL[urls.size()]));
     * classes.forEach(className->{
     * try
     * {
     * Class
     * cls=urlClassLoader.loadClass(className.replaceAll("/",".").replace(".class",
     * ""));
     * Class[] interfaces=cls.getInterfaces();
     * for(Class intface:interfaces)
     * {
     * if(intface.equals(Plugin.class))
     * {
     * Plugin plugin=(Plugin) cls.newInstance();
     * plugins.add(plugin);
     * break;
     * }
     * }
     * }
     * catch (Exception e){e.printStackTrace();}
     * });
     * if(!plugins.isEmpty())loadedPlugins.getChildren().add(new
     * Label("Loaded plugins:"));
     * plugins.forEach(plugin -> {
     * plugin.initialize();
     * loadedPlugins.getChildren().add(new Label(plugin.name()));
     * });
     * }
     * Rectangle2D screenbounds=Screen.getPrimary().getVisualBounds();
     * Scene scene=new
     * Scene(loadedPlugins,screenbounds.getWidth()/2,screenbounds.getHeight()/2);
     * primaryStage.setScene(scene);
     * primaryStage.show();
     * }
     * public static void main(String[] a)
     * {
     * launch(a);
     * }
     * }
     * 
     */

    // Mari buat dua plugin. Jelasnya, sumber plugin harus berada dalam modul
    // terpisah.
    /*
     * package plugins;
     * import main.Plugin;
     * public class FirstPlugin implements Plugin
     * {
     * //this plugin has default behaviour
     * }
     */

    // Plugin kedua:
    /*
     * package plugins;
     * import main.Plugin;
     * public class AnotherPlugin implements Plugin
     * {
     * 
     * @Override
     * public void initialize() //overrided to show user's home directory
     * {
     * System.out.println("User home directory: "+System.getProperty("user.home"));
     * }
     * }
     */

    /*
     * Plugin ini harus dikemas ke dalam Jars standar - proses ini bergantung pada
     * IDE Anda atau alat lainnya.
     * Ketika Jars akan dimasukkan ke dalam 'plugin' secara langsung,
     * MainApplication akan mendeteksinya dan membuat instance kelas yang sesuai.
     */
    // ---------------
    @Override
    public void start(Stage primaryStage) {
        File pluginDirectory = new File("plugins"); // Arbitrary directory
        if (!pluginDirectory.exists())
            pluginDirectory.mkdir();

        VBox loadedPlugins = new VBox(6); // Container to show visual info later
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(loadedPlugins, screenBounds.getWidth() / 2, screenBounds.getHeight() / 2);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Load plugins
        File[] pluginFiles = pluginDirectory.listFiles();
        if (pluginFiles != null) {
            for (File file : pluginFiles) {
                try {
                    String className = file.getName().replace(".class", "");
                    Class<?> pluginClass = Class.forName(className);
                    Object pluginInstance = pluginClass.newInstance();
                    if (pluginInstance instanceof Plugin) {
                        ((Plugin) pluginInstance).initialize();
                        loadedPlugins.getChildren()
                                .add(new javafx.scene.control.Label(((Plugin) pluginInstance).name()));
                    }
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        launch(args);
    }
}
