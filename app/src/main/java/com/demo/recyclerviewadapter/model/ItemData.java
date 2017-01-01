package com.demo.recyclerviewadapter.model;

/**
 * Created by hzsunyj on 16/12/30.
 */
public class ItemData {

    public int tag;

    public int holderType;

    public String itemDesc;

    public Object data;

    public ItemData(int tag, int holderType) {
        this.tag = tag;
        this.holderType = holderType;
    }

    public ItemData(int tag, int holderType, String itemDesc) {
        this.tag = tag;
        this.holderType = holderType;
        this.itemDesc = itemDesc;
    }

    public ItemData(int tag, int holderType, Object data) {
        this.tag = tag;
        this.holderType = holderType;
        this.data = data;
    }
}
