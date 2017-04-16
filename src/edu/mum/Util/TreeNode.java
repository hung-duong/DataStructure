/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.Util;

/**
 *
 * @author hungduong
 */
public class TreeNode {
    public enum Color {RED, BLACK};

    public int data;
    public Color color;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int data) {
        this.data = data;
        left = right = parent = null;
    }
}