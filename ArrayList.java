import java.lang.constant.DynamicCallSiteDesc;
import java.util.Scanner;


class DynamicArray{
    int intialArraySize = 16;
    int array[] = new int[intialArraySize];
    int size =0 ;
    int capacity = intialArraySize;



    public void add(int newNumber){
        if (size == capacity){
            expandArray();
        }
        array[size] = newNumber;
        size++;
    }

    private void expandArray(){
        capacity = capacity * 2;
        array = java.util.Arrays.copyOf(array, capacity);
    }

    public void displayInfo(){

        System.out.println("Elements in the List :");
        for (int i=0; i<size; i ++ ){
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }

    public void insertAtPosition( int position , int insertNumber){
        if (size == capacity){
            expandArray();
        }
        for(int i = size-1; i>= position; i--){
            array[i+1] = array[i];
        }
        array[position] = insertNumber;
        size++;
    }

    public void deleteAtPosition(int pos){
        for(int i=pos+1; i<size; i++){
            array[i-1]= array[i];
        }
        size--;
    }

    public void deleteAtEnd(){
        size = size-1;
    }
}


public class Main {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        DynamicArray list = new DynamicArray();
        while(true){
            System.out.println("-------------------------------------------------------");
            System.out.println("Enter 1 to Insert Number ");
            System.out.println("Enter 2 to Display Number");
            System.out.println("Enter 3 to Insert number to particular position");
            System.out.println("Enter 4 to Delete number from particular position");
            System.out.println("Enter 5 to Delete last added number");
            System.out.println("Enter 6 to exit ");
            System.out.println("-------------------------------------------------------");
            System.out.print("\nEnter the Number :");
            int number = input.nextInt();

            switch (number) {
                case 1:
                    System.out.print("Enter the number to be inserted : ");
                    int newNumber = input.nextInt();
                    list.add(newNumber);
                    break;
                case 2:
                    list.displayInfo();
                    break;
                case 3:
                    System.out.print("Enter the Position :");
                    int position = input.nextInt();
                    if(position < 0){
                        System.out.println("Invalid Position");
                    }

                    System.out.print("Enter the Number :");
                    int insertNumber = input.nextInt();
                    list.insertAtPosition(position,insertNumber);
                    break;
                case 4:
                    System.out.print("Enter the Position :");
                    int pos = input.nextInt();
                    if(pos < 0){
                        System.out.println("Invalid Position");
                    }
                    list.deleteAtPosition(pos);
                    break;
                case 5:
                    list.deleteAtEnd();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Number");
            }

        }
    }
}