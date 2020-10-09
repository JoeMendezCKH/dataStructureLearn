package com.joe.datastructure.part5;

/**
 * @author ckh
 * @create 10/9/20 10:09 AM
 */
public interface HashFamily<AnyType> {
    int hash(AnyType x, int which);

    int getNumberOfFunctions();

    void generateNewFunctions();
}