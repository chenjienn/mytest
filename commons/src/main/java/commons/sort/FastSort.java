package commons.sort;

public class FastSort implements Sort {

    public void sortIntArray(int[] input) throws RuntimeException {
        if (input != null && input.length != 0) {
            doSort(input, 0, input.length - 1);
        } else {
            throw new RuntimeException("illegal input, please check it.");
        }
    }

    private void doSort(int[] input, int headIndex, int tailIndex) {
        int headCusor = headIndex;
        int tailCusor = tailIndex;
        while (headCusor < tailCusor) {
            if (input[headCusor] <= input[tailCusor]) {
                headCusor++;
            } else {
                swap(input, headCusor, tailCusor);
                tailCusor--;
            }
        }
        if (headCusor == tailIndex || tailCusor == headIndex) {
            return;
        }
        doSort(input, tailCusor, tailIndex);
        doSort(input, headIndex, --headCusor);
    }

    private void swap(int input[], int index1, int index2) {
        int temp = input[index2];
        input[index2] = input[index1];
        input[index1] = temp;
    }

}
