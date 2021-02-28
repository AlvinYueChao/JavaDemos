package org.example.alvin.algorithm.leetcode;

/**
 * leetcode 945
 */
public class MinIncrementForUnique {
    public static void main(String[] args) {
        int[] A = {381,256,383,463,594,559,368,425,806,589,970,602,283,513,472,852,737,880,717,253,272,163,879,900,323,23,474,788,702,675,21,101,729,818,182,816,951,601,551,32,413,466,953,440,11,567,68,992,659,719,693,940,404,278,78,22,477,743,739,2,616,831,866,769,418,703,701,64,38,346,643,380,644,761,771,283,971,553,627,635,673,154,674,431,968,714,973,991,833,586,600,469,369,418,913,646,169,37,439,440,65,226,331,376,624,155,821,497,69,99,943,31,648,178,654,987,918,437,431,289,440,957,37,478,895,106,116,814,282,797,301,32,819,331,461,59,650,828,219,933,633,548,205,876,423,42,925,368,294,58,33,43,874,867,469,81,139,947,560,795,76,65,777,115,820,934,432,115,717,445,501,887,539,138,372,849,511,80,506,35,879,248,729,994,896,528,324,698,546,908,242,693,152,405,777,364,283,352,373,7,143,740,692,652,136,115,489,483,125,965,817,872,172,656,813,323,985,95,793,144,251,189,115,670,242,799,769,957,774,990,557,31,332,394,966,421,270,799,919,46,980,722,995,648,7,678,226,988,932,860,708,253,926,822,633,170,199,566,593,408,813,678,258,30,606,329,889,234,548,197,966,642,753,890,453,546,449,619,334,821,365,771,16,363,479,901,722,733,636,900,724,631,920,764,14,868,188,748,413,392,153,428,999,827,736,642,214,63,932,908,2,911,748,98,154,176,256,902,421,538,424,464,250,315,252,284,607,23,937,513,502,421,731,761,722,965,414,85,798,712,25,492,809,948,349,471,444,744,703,474,185,587,24,355,307,66,97,788,453,128,933,315,440,694,154,782,845,491,709,723,991,775,360,510,393,535,895,96,894,503,145,933,194,26,470,573,50,628,563,563,80,356,130,467,370,329,881,624,110,657,996,365,770,657,475,404,213,417,266,486,669,886,145,809,761,628,192,71,136,321,291,810,343,162,975,704,803,497,96,586,444,318,87,316,272,356,713,116,378,758,309,855,864,189,649,639,169,557,475,240,712,895,896,105,378,89,463,663,706,57,113,632,834,607,93,81,580,216,747,302,825,902,531,702,764,626,646,403,892,177,161,724,211,520,901,357,735,869,658,90,516,797,997,458,56,349,499,929,65,915,439,99,751,121,133,236,547,660,860,589,637,481,504,662,269,295,622,621,180,195,548,833,311,173,48,530,528,612,546,658,870,317,796,226,330,494,519,737,26,738,806,1,561,18,138,871,54,907,667,765,675,758,731,894,359,382,649,530,678,368,418,392,39,736,568,885,737,414,775,63,636,931,891,316,280,294,886,342,413,329,266,870,443,534,401,335,403,894,280,696,214,909,466,298,428,739,856,812,129,967,477,951,170,940,192,869,270,840,163,854,661,121,936,434,183,843,54,38,737,89,746,94,939,137,562,646,366,95,488,335,890,203,223,597,443,286,140,839,95,903,940,130,924,265,792,324,445,710,546,754,396,62,343,884,802,926,589,328,481,493,245,871,59,331,978,560,943,6,811,625,856,734,999,337,743,844,693,791,819,271,283,404,23,905,811,131,818,329,606,489,444,609,907,414,26,851,951,807,156,421,756,863,869,923,641,138,420,959,132,932,359,590,813,92,112,478,904,970,654,191,793,376,264,589,442,519,970,38,873,433,845,876,736,473,521,596,395,713,854,336,954,562,293,162,726,281,808,946,352,377,301,255,998,827,865,27,952,823,823,926,411,76,569,535,215,742,985,716,794,772,810,159,605,608,874,437,260,536,493,16,48,188,492,658,520,574,991,87,372,545,790,883,620,655,894,791,580,12,412,70,962,826,345,100,564,352,723,837,596,818,8,233,430,465,812,175,572,537,647,13,43,90,393,597,734,650,107,865,394,816,171,380,670,630,518,923,811,595,677,415,512,630,837,199,457,184,197,35,119,757,329,304,143,576,415,55,382,807,756,974,857,497,792,785,410,387,560,442,622,813,918,643,524,215,399,224,728,540,153,165,28,113,619,637,528,789,546,256,765,366,44,216,444,613,779,861,774,751,589,193,666,694,268,371,293,995,697,359,194,340,241,830,188,378,534,251,168,961,903,26,533,43,433,109,804,200,300,85,968,500,422,552,179,797,287,846,739,294,486,294,940,848,538,689,77,800,358,268,327,889,103,986,463,627,506,62,765,401,482,821,311,140,45,689,66,593,68,112,393,291,107,941,946,962,980,909,566,404,741,523,227,775,163,651,949,535,145,358,510,432,149,598,880,971,181,658,21,149,513,606};
        long start = System.currentTimeMillis();
        int stepCount = minIncrementForUnique(A);
        long end = System.currentTimeMillis();
        System.out.println("步数: " + stepCount + " ,消耗时间: " + (end - start) + " 毫秒");
    }

    private static int minIncrementForUnique(int[] A) {
        int[] countOfItems = new int[80000];
        for (int number : A) {
            countOfItems[number]++;
        }

        int minIndex = 0;
        int dupTimes = 0;

        for (int i = 0; i < 80000; i++) {
            if (countOfItems[i] != 0) {
                minIndex = i;
                break;
            }
        }

        int stepCount = 0;
        for (int i = minIndex; i < 80000; i++) {
            if (countOfItems[i] > 1) {
                dupTimes += (countOfItems[i] - 1);
                stepCount -= i * (countOfItems[i] - 1);
            }
            else if (dupTimes > 0 && countOfItems[i] == 0) {
                dupTimes--;
                stepCount += i;
            }
        }

        return stepCount;
    }
}