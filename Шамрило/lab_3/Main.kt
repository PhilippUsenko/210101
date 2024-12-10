data class TreeNode<T : Comparable<T>>(val value: T, val left: TreeNode<T>? = null, val right: TreeNode<T>? = null)
//обобщение с типом Т
fun main() {
    val tree = TreeNode(10,
        TreeNode(5, TreeNode(2), TreeNode(7)),
        TreeNode(15, right = TreeNode(20))
    )

    val countLeaves: (TreeNode<*>?) -> Int = run {
        var countLeaves: (TreeNode<*>?) -> Int = { _ -> 0 } //основная реализация функции
        countLeaves = { node ->
            when {
                node == null -> 0
                node.left == null && node.right == null -> 1
                else -> countLeaves(node.left) + countLeaves(node.right)
            }
        }
        countLeaves
    }

    val findMax: (TreeNode<Int>?) -> Int? = run {
        var findMax: (TreeNode<Int>?) -> Int? = { null }
        findMax = { node ->
            when {
                node == null -> null
                else -> {
                    val leftMax = findMax(node.left)
                    val rightMax = findMax(node.right)
                    maxOf(node.value, leftMax ?: node.value, rightMax ?: node.value)
                }
            }
        }
        findMax
    }

    println("Количество листьев: ${countLeaves(tree)}")
    println("Максимальное значение: ${findMax(tree)}")
}