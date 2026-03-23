package com.example.sealedclasshomework.sealed_class

fun main() {
    getPurchaseStatus(PurchaseStatus.Canceled("ну вот так вот"))
}

fun getPurchaseStatus(status: PurchaseStatus) = when (status) {
    PurchaseStatus.InProgress -> println("доставка в процессе")
    PurchaseStatus.Ready -> println("доставка готова")
    is PurchaseStatus.Canceled -> {
        println("Доставка отменена, причина: ${status.reason}")
    }
}