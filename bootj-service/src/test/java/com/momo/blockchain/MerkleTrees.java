package com.momo.blockchain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author majunjie
 * @date 2018/2/6 16:17
 */
public class MerkleTrees {

    private List<String> txList;
    private String root;

    public MerkleTrees(List<String> txList) {
        this.txList = txList;
        this.root = "";
    }

    public void initHash(){
        List<String> newTxList = getNewDatas(txList);
        while (newTxList.size()!=1) {
            newTxList = getNewDatas(newTxList);
        }
        root = newTxList.get(0);
    }

    private List<String> getNewDatas(List<String> originDatas) {
        List<String> newTxList;
        int originSize = originDatas.size();
        if (originSize%2 == 1) {
            newTxList = new ArrayList<>((originSize + 1 )/2);
        } else {
            newTxList = new ArrayList<>(originSize/2);
        }

        int index = 0;
        while (index < originSize) {
            String left = originDatas.get(index);
            index++ ;
            if (index == originSize) {
                newTxList.add(left);
            } else {
                String right = originDatas.get(index);
                index++ ;
                newTxList.add(left+right);
            }
        }
        return newTxList;
    }

    public String getRoot() {
        return root;
    }

    public static void main(String[] args) {
        List<String> datas = new ArrayList<>();
        datas.add("a");
        datas.add("b");
        datas.add("c");
        datas.add("d");
        datas.add("e");

        MerkleTrees merkleTrees = new MerkleTrees(datas);
        merkleTrees.initHash();
        System.out.println(merkleTrees.getRoot());
    }

}
