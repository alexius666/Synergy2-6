package com.company;

public class Printer {
        private final String modelPrinter;
        private final String serial;
        private int printedLists=0;
        public int issueYear;

        public Printer(String modelPrinter){
            this.modelPrinter = modelPrinter;
            this.issueYear = 2022;
            this.serial="XXXXXXXXX";
        }
        public Printer(String modelPrinter, String serial, int issueYear){
            this.modelPrinter=modelPrinter;
            this.serial=serial;
            this.issueYear=issueYear;
        }
        public Printer(){
            this.modelPrinter="not determined";
            this.serial="XXXXXXXXX";
        }
        public int setPrintedLists(int printedLists){
            this.printedLists=printedLists;
            return printedLists;
        }

        public int getPrintedLists() {
            return printedLists;
        }

    @Override
    public String toString() {
        return "Printer{" +
                "model='" + modelPrinter + '\'' +
                ", serial='" + serial + '\'' +
                ", printedLists=" + printedLists +
                ", issueYear=" + issueYear +
                '}';
    }
}
