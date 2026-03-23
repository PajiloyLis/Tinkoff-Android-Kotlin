package com.example.sealedclasshomework.sealed_class

sealed class PurchaseStatus {

    data object InProgress: PurchaseStatus()

    data object Ready: PurchaseStatus()

    data class Canceled(val reason: String): PurchaseStatus()
}