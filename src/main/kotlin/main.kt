const val VISA = "Visa"
const val MASTERCARD = "Mastercard"
const val MAESTRO = "Maestro"
const val MIR = "Mir"
const val VK = "VKPay"

fun main() {

}

fun calculateCommission(cardType: String = VK, lastTransferSum: Int = 0, transferSum: Int): Int {
    return when (cardType) {
        MASTERCARD, MAESTRO -> {
            return if (lastTransferSum < 75_000_00) 0 else transferSum * 6 / 1000 + 20_00
        }
        VISA, MIR -> {
            val percentCommission = transferSum * 75 / 10000
            return if (percentCommission < 35_00) 35_00 else percentCommission
        }
        else -> 0
    }
}
