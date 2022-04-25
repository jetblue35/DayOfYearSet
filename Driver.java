/**
 * This class testing DayOfYearSet.java .
 * @author Muhammet_Emrah_Kucuk_1801042100.
 */

import java.util.ArrayList;
import hw7.DayOfYearSet.DayOfYear;
import hw7.*;
public class Driver {
    public static void main(String[] args)
    {   
        System.out.println("Test Driver!\n");
        System.out.println("Sets are creating with add methods...\n");
        
        DayOfYearSet set1 = new DayOfYearSet(5);
        DayOfYearSet same = new DayOfYearSet(5);
        
        DayOfYear doy1 = new DayOfYear(8, 1);
        DayOfYear doy2 = new DayOfYear(10, 11);
        DayOfYear doy3 = new DayOfYear(19, 5);
        DayOfYear doy4 = new DayOfYear(23, 4);
        DayOfYear doy5 = new DayOfYear(29, 10);

        
        set1.add(doy1);
        set1.add(doy2);
        set1.add(doy3);
        set1.add(doy4);
        set1.add(doy5);
        
        same.add(doy1);
        same.add(doy2);
        same.add(doy3);
        same.add(doy4);
        same.add(doy5);
        
        
        System.out.println("Set1's element:\n");
        System.out.println(set1);

        DayOfYear doy6 = new DayOfYear(14, 8);
        DayOfYear doy7 = new DayOfYear(7, 9);
        DayOfYear doy8 = new DayOfYear(31, 1);
        DayOfYear doy9 = new DayOfYear(5, 12);
        DayOfYear doy10 = new DayOfYear(19, 3);
        DayOfYear doy11 = new DayOfYear(2, 10);
        DayOfYear doy12 = new DayOfYear(27, 6);

        ArrayList<DayOfYear> doyList = new ArrayList<DayOfYear>();
        doyList.add(doy6);
        doyList.add(doy7);
        doyList.add(doy8);
        doyList.add(doy9);
        doyList.add(doy10);
        doyList.add(doy11);
        doyList.add(doy12);

        DayOfYearSet set2 = new DayOfYearSet(doyList);
       
        System.out.println("Set2's element:\n");
        System.out.println(set2);

        System.out.println("SetSame's element:\n");
        System.out.println(same);
        
        System.out.println("Test equal methods (Set1 and Set2):\n");
        if(set1.equals(set2))
            System.out.println("These Sets are equal!\n");
        else
            System.out.println("These Sets are not equal!\n");    
        
        System.out.println("Test equal methods (Set1 and SetSame):\n");
        if(set1.equals(same))
            System.out.println("These Sets are equal!\n");
        else
            System.out.println("These Sets are not equal!\n");    
        
        System.out.println("Remove Set1's 3. index:\n");
        set1.remove(3);
        
        System.out.println("After remove operation, Set1's elements:\n");
        System.out.println(set1);
        
        System.out.println("Remove Set2's 5. index:\n");
        set2.remove(5);
        
        System.out.println("After remove operation, Set2's elements:\n");
        System.out.println(set2);

        DayOfYearSet unionSet = new DayOfYearSet(20);
        
        System.out.println("Test union methods (Set1 and Set2):\n");
        unionSet = set1.union(set2);
        
        System.out.println("After union operation, UnionSet's elements:\n");
        System.out.println(unionSet);

        DayOfYearSet set3 = new DayOfYearSet(5);
        DayOfYearSet set4 = new DayOfYearSet(5);
        
        System.out.println("Set3 and Set4 are creating with add method...\n");
        set3.add(doy1);
        set3.add(doy2);
        set3.add(doy3);
        set3.add(doy9);
        set3.add(doy10);
        
        System.out.println("Set3's element:\n");
        System.out.println(set3);
        
        set4.add(doy1);
        set4.add(doy2);
        set4.add(doy3);
        set4.add(doy11);
        
        
        System.out.println("Set4's element:\n");
        System.out.println(set4);
        
        DayOfYearSet intersectionSet = new DayOfYearSet(5);
        
        System.out.println("Test intersection methods (Set3 and Set4):\n");
        intersectionSet = set3.intersection(set4);
        
        System.out.println("After intersection operation, IntersectionSet's elements:\n");
        System.out.println(intersectionSet);

        DayOfYear doy13 = new DayOfYear(1, 1);
        DayOfYear doy14 = new DayOfYear(2, 2);
        DayOfYear doy15 = new DayOfYear(3, 3);

        DayOfYear doy16 = new DayOfYear(4, 4);
        DayOfYear doy17 = new DayOfYear(5, 5);
        DayOfYear doy18 = new DayOfYear(6, 6);
        
        System.out.println("Set5 and Set6 are creating with add method...\n");
        
        DayOfYearSet set5 = new DayOfYearSet(3);
        set5.add(doy13);
        set5.add(doy14);
        set5.add(doy15);
        
        System.out.println("Set5's element:\n");
        System.out.println(set5);
        
        DayOfYearSet set6 = new DayOfYearSet(3);
        set6.add(doy16);
        set6.add(doy17);
        set6.add(doy18);
        
        System.out.println("Set6's element:\n");
        System.out.println(set6);
    
        DayOfYearSet differenceSet = new DayOfYearSet(6);
        
        System.out.println("Test difference methods (Set5 and Set6):\n");
        differenceSet = set5.difference(set6);
        
        System.out.println("After difference operation, DifferenceSet's elements:\n");
        System.out.println(differenceSet);
        
        System.out.println("Set1 is saving...\n");
        set1.saveFile("set1.txt");
        
        System.out.println("Set5 is saving...\n");
        set5.saveFile("set5.txt");
        
        //DayOfYearSet complementSet = new DayOfYearSet(365);
        //complementSet = set6.complement();
        
        System.out.printf("Total obj: %d\n", DayOfYear.getNumOfObj());
        System.out.println("\nI have wrote method complement but does not work, I am getting error...\n");
        System.out.println("Other than that, everything works exactly as expected.\n");
        System.out.println("\nThere are javadocs in both folders.");
        //complementSet.saveFile("complement.txt");
    }
}
