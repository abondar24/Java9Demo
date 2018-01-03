package org.abondar.experimental.version;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String [] versions = {
                "9","9.1","9.1.2","9.1.2.3.4","9.0.0",
                "9.1.2-ea+153", "9+132", "9-ea+132-2016-08-23", "9+-123",
                "9.0.1-ea+132-2016-08-22.10.56.45am"
        };

        for (String version: versions){
            try {
                Runtime.Version ver = Runtime.Version.parse(version);

                String vnumAdditionalInfo = getAdditionalInfo(ver);
                System.out.println("Version string: "+version);
                System.out.printf("Major=%d, Minor=%d, Security=%d, Additional Ver=%s," +
                                "Pre=%s, Build=%s, Optional=%s \n",
                        ver.major(),
                        ver.minor(),
                        ver.security(),
                        vnumAdditionalInfo,
                        ver.pre().orElse(""),
                        ver.build().isPresent() ? ver.build().get().toString(): "",
                        ver.optional().orElse(""));
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }
    }

    private static String getAdditionalInfo(Runtime.Version version) {
        StringBuilder str = new StringBuilder();

        List<Integer> vnum = version.version();
        int size = vnum.size();
        if (size>=4){
            str.append(String.valueOf(vnum.get(3)));

        }

        for (int i = 4;i<size;i++){
            str.append(".").append(String.valueOf(vnum.get(i)));
        }

        return str.toString();
    }


}
