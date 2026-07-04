/*
 * @lc app=leetcode id=652 lang=cpp
 *
 * [652] Find Duplicate Subtrees
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    public:
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        unordered_map<string, int> subtrees;
        vector<TreeNode*> duplicates;
        traverse(root, subtrees, duplicates);
        return duplicates;
    }

    static string traverse(TreeNode* node, unordered_map<string, int>& subtrees, vector<TreeNode*>& duplicates) {
        if(node == nullptr) {
            return "";
        }
        string left = traverse(node->left, subtrees, duplicates);
        string right = traverse(node->right, subtrees, duplicates);
        string subtree = to_string(node->val) + "L" + left + "R" + right;
        if(subtrees.contains(subtree) && subtrees[subtree] == 1) {
            duplicates.push_back(node);
        }
        subtrees[subtree]++;
        return subtree;
    }
};
// @lc code=end

