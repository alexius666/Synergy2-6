package com.company;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Cartridge {
    private final String modelCartridge;
    private final int resourceCartridge;
    public String[] compatiblePrinters;
    private Cartridge[] cartridges;

    public Cartridge(String modelCartridge, int resourceCartridge, String[] compatiblePrinters){
        this.modelCartridge=modelCartridge;
        this.resourceCartridge = resourceCartridge;
        this.compatiblePrinters=compatiblePrinters;
    }

    public void addCartridge(Cartridge cartridge){
        if(cartridges == null) {
            cartridges = new Cartridge[10];
        }
        int index = ArrayUtils.indexOf(cartridges,cartridge);
        if(index==-1){
            for(int i=0;i<cartridges.length;i++){
                if (cartridges[i]==null){
                    cartridges[i]=cartridge;
                    break;
                } else if(i==cartridges.length-1){
                    Cartridge[] newOne = new Cartridge[cartridges.length+5]; // расширение массива на 5
                    System.arraycopy(cartridges,0,newOne,0,cartridges.length-1);
                    newOne[cartridges.length]=cartridge;
                    this.cartridges=newOne;
                    break;
                }
            }
        }
    }
    public Cartridge[] getCartridges(){
        return cartridges;
    }

    @Override
    public String toString() {
        return "Cartridge{" +
                "modelCartridge='" + modelCartridge + '\'' +
                ", resourceCartridge=" + resourceCartridge +
                ", compatiblePrinters=" + Arrays.toString(compatiblePrinters) +
                '}';
    }
}
