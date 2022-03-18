import org.junit.Assert.assertEquals
import org.junit.Test

const val VISA = "Visa"
const val MASTERCARD = "Mastercard"
const val MAESTRO = "Maestro"
const val MIR = "Mir"
const val VK = "VKPay"

class MainKtTest {

    @Test
    fun calculateCommission_1() {
        val transferSum = 1_00

        val result = calculateCommission(transferSum = transferSum)

        assertEquals(0, result)
    }

    @Test
    fun calculateCommission_last1500And100() {
        val transferSum = 100
        val lastTransferSum = 1500_00

        val result = calculateCommission(lastTransferSum = lastTransferSum, transferSum = transferSum)

        assertEquals(0, result)
    }

    @Test
    fun calculateCommission_MAESTROAndLast750000And1111() {
        val cardType = MAESTRO
        val lastTransferSum = 750_000_00
        val transferSum = 1_111_00

        val result = calculateCommission(cardType, lastTransferSum, transferSum)

        assertEquals(26_67, result)
    }

    @Test
    fun calculateCommission_MAESTROAndLast50000And1111() {
        val cardType = MAESTRO
        val lastTransferSum = 50_000_00
        val transferSum = 1_111_00

        val result = calculateCommission(cardType, lastTransferSum, transferSum)

        assertEquals(0, result)
    }

    @Test
    fun calculateCommission_VISAAndLast50000And100() {
        val cardType = VISA
        val lastTransferSum = 50_000_00
        val transferSum = 100_00

        val result = calculateCommission(cardType, lastTransferSum, transferSum)

        assertEquals(35_00, result)
    }

    @Test
    fun calculateCommission_VISAAndLast50000And28900() {
        val cardType = VISA
        val lastTransferSum = 50_000_00
        val transferSum = 28_900_00

        val result = calculateCommission(cardType, lastTransferSum, transferSum)

        assertEquals(216_75, result)
    }

    @Test
    fun calculateCommission_VKAndLast5000And100570() {
        val cardType = VK
        val lastTransferSum = 5_000_00
        val transferSum = 100_570_00

        val result = calculateCommission(cardType, lastTransferSum, transferSum)

        assertEquals(0, result)
    }

    @Test
    fun calculateCommission_MIRAndLast500000And1500() {
        val cardType = MIR
        val lastTransferSum = 500_000_00
        val transferSum = 1_500_00

        val result = calculateCommission(cardType, lastTransferSum, transferSum)

        assertEquals(35_00, result)
    }

    @Test
    fun calculateCommission_VisaAndMore4600() {
        val cardType = VISA
        val lastTransferSum = 50_000_00
        val transferSum = 28_900_00

        val result = calculateCommission(cardType, lastTransferSum, transferSum)

        assertEquals(21675, result)
    }

    @Test
    fun calculateCommission_MASTERCARDAndLast500000And10000() {
        val cardType = MASTERCARD
        val lastTransferSum = 500_000_00
        val transferSum = 10_000_50

        val result = calculateCommission(cardType, lastTransferSum, transferSum)

        assertEquals(80_00, result)
    }

}