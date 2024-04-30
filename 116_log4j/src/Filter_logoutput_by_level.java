public class Filter_logoutput_by_level {
    // Filter Logoutput by level (log4j 1.x)/Filter Logoutput berdasarkan level
    // (log4j 1.x)

    /*
     * Anda dapat menggunakan filter untuk mencatat hanya pesan "lebih rendah" dari
     * misalnya. tingkat KESALAHAN. Namun filter tersebut tidak didukung oleh
     * Konfigurasi Properti. Jadi, Anda harus mengubah konfigurasi XML untuk
     * menggunakannya. Lihat log4j-Wiki tentang filter.
     * 
     * Contoh "tingkat tertentu"
     * 
     * <appender name="info-out" class="org.apache.log4j.FileAppender">
     * <param name="File" value="info.log"/>
     * <layout class="org.apache.log4j.PatternLayout">
     * <param name="ConversionPattern" value="%m%n"/>
     * </layout>
     * <filter class="org.apache.log4j.varia.LevelMatchFilter">
     * <param name="LevelToMatch" value="info" />
     * <param name="AcceptOnMatch" value="true"/>
     * </filter>
     * <filter class="org.apache.log4j.varia.DenyAllFilter" />
     * </appender>
     */

    // atau "Level range"

    /*
     * <appender name="info-out" class="org.apache.log4j.FileAppender">
     * <param name="File" value="info.log"/>
     * <layout class="org.apache.log4j.PatternLayout">
     * <param name="ConversionPattern" value="%m%n"/>
     * </layout>
     * <filter class="org.apache.log4j.varia.LevelRangeFilter">
     * <param name="LevelMax" value="info"/>
     * <param name="LevelMin" value="info"/>
     * <param name="AcceptOnMatch" value="true"/>
     * </filter>
     * </appender>
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
    }

}
