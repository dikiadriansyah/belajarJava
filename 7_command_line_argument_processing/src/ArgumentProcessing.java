import java.io.File;

import com.google.gwt.util.tools.ToolBase;

public class ArgumentProcessing extends ToolBase {

    // parameter | Details
    // args | Argumen baris perintah. dengan asumsi bahwa metode utama dipanggil
    // oleh peluncur Java, args akan menjadi non-null, dan tidak akan memiliki
    // elemen null.

    // Argument processing using GWT ToolBase / Pemrosesan argumen menggunakan GWT
    // ToolBase

    // jika anda ingin menguraikan argumen baris perintah yang lebih kompleks,
    // misal. dengan parameter opsional, daripada yang terbaik untuk digunakan
    // pendekatan gwt google. Semua kelas tersedia untuk umum di:

    // https://gwt.googlesource.com/gwt/+/2.8.0-beta1/dev/core/src/com/google/gwt/util/tools/ToolBase.java

    // contoh untuk menangani baris perintah myprogram -dir "~/Documents" - port
    // 8888 adalah

    protected File dir;
    protected int port;

    public ArgumentProcessing() {
        this.registerHandler(new ArgHandlerDir() {
            @Override
            public void setDir(File dir) {
                this.dir = dir;
            }
        });
        this.registerHandler(new ArgHandlerInt() {
            @Override
            public String[] getTagArgs() {
                return new String[] { "port" };
            }

            @Override
            public void setInt(int value) {
                this.port = value;
            }
        });
    }

    public static void main(String[] args)  {

        ArgumentProcessing myShell = new ArgumentProcessing();
        if (myShell.processArgs(args)) {
        // main program operation
        System.out.println(String.format("port: %d; dir: %s",
        myShell.getPort(), myShell.getDir()));
        }
        System.exit(1);
        }

    private Object getDir() {
        return null;
    }

    private Object getPort() {
        return null;
    }
       

        System.out.println("Hello, World!");
    }}
