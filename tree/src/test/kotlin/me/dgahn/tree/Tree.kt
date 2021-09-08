package me.dgahn.tree

class Tree(
    var head: Node?
) {

    fun add(data: Int) {
        if (this.head == null) {
            this.head = Node(data)
        } else {
            var currentNode = this.head
            while (true) {
                if (data < currentNode!!.value) {
                    if (currentNode.left != null) {
                        currentNode = currentNode.left
                    } else {
                        currentNode.left = Node(data)
                        break
                    }
                } else {
                    if (currentNode.right != null) {
                        currentNode = currentNode.right
                    } else {
                        currentNode.right = Node(data)
                        break
                    }
                }
            }
        }
    }

    fun search(data: Int): Node? {
        if (this.head == null) {
            return null
        } else {
            var currentNode = this.head
            while (currentNode != null) {
                currentNode = if (currentNode.value == data) {
                    return currentNode
                } else if (data < currentNode.value) {
                    currentNode.left
                } else {
                    currentNode.right
                }
            }
        }
        return null
    }

    fun delete(data: Int) {
        var searched = false
        var currentParentNode = this.head
        var currentNode = this.head

        if (this.head == null) {
            return
        } else {
            if (this.head?.value == data && this.head?.left == null && this.head?.right == null) {
                this.head = null
                return
            }

            while (currentNode != null) {
                if (currentNode.value == data) {
                    searched = true
                    return
                } else if (data < currentNode.value) {
                    currentParentNode = currentNode
                    currentNode = currentNode.left
                } else {
                    currentParentNode = currentNode
                    currentNode = currentNode.right
                }
            }

            if (!searched) {
                return
            }

            if (currentNode?.left == null && currentNode?.right == null) {
                if (data < currentParentNode?.value!!) {
                    currentParentNode.left = null
                    currentNode = null
                } else {
                    currentParentNode.right = null
                    currentNode = null
                }
            } else if (currentNode.left != null && currentNode.right == null) {
                if (data < currentParentNode?.value!!) {
                    currentParentNode.left = currentNode.left
                    currentNode = null
                } else {
                    currentParentNode?.right = currentNode.left
                    currentNode = null
                }
            } else if (currentNode.left == null && currentNode.right != null) {
                if (data < currentParentNode?.value!!) {
                    currentParentNode?.left = currentNode.right
                    currentNode = null
                } else {
                    currentParentNode?.right = currentNode.right
                    currentNode = null
                }
            } else {
                if(data < currentParentNode?.value!!) {
                    var changeNode = currentNode.right
                    var changeParentNode = currentNode.right
                    while (changeNode?.left != null) {
                        changeParentNode = changeNode
                        changeNode = changeNode.left
                    }

                    if(changeNode?.right != null) {
                        changeParentNode?.left = changeNode.right
                    } else {
                        changeParentNode?.left = null
                    }

                    currentParentNode.left = changeNode
                    changeNode?.right = currentNode.right
                    changeNode?.left = currentNode.left
                    currentNode = null
                } else {
                    var changeNode = currentNode.right
                    var changeParentNode = currentNode.right
                    while (changeNode?.left != null) {
                        changeParentNode = changeNode
                        changeNode = changeNode.left
                    }

                    if(changeNode?.right != null) {
                        changeParentNode?.left = changeNode.right
                    } else {
                        changeParentNode?.left = null
                    }

                    currentParentNode.right = changeNode
                    changeNode?.right = currentNode.right
                    changeNode?.left = currentNode.left
                    currentNode = null
                }
            }
        }
    }

}
