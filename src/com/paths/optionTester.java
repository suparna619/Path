package com.paths;

import static java.lang.System.exit;

public class OptionTester {

    private String fileOption;
    private String countryOption;

    public OptionTester(String fileOption, String countryOption){
        this.fileOption = fileOption;
        this.countryOption = countryOption;
    }

    public void testOption(){
        if (!fileOption.equals("-f")){
            System.out.println("Wrong option "+fileOption);
            exit(0);
        }
        if (!countryOption.equals("-c")){
            System.out.println("Wrong option "+countryOption);
            exit(0);
        }
    }
}
