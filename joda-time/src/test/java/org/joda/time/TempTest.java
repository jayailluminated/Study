/*
 *  Copyright 2001-2006 Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.time;

import junit.framework.TestCase;

/**
 * Test.
 */
public class TempTest extends TestCase {

    static DateTimeZone CHICAGO = DateTimeZone.forID("America/Chicago");
    
    public static void main(String[] args) {
        DateTime fallAmbig = new DateTime("2007-11-04T01:59:59-06:00", CHICAGO);

        System.out.println("Rounding down minute of hour: America/Chicago");
        DateTime americaHour = fallAmbig.minuteOfHour().roundFloorCopy();
        System.out.println("Original: " + fallAmbig);
        System.out.println("     New: " + americaHour);

        System.out.println("Rounding down minute of day: America/Chicago");
        DateTime americaMinute = fallAmbig.minuteOfDay().roundFloorCopy();
        System.out.println("Original: " + fallAmbig);
        System.out.println("     New: " + americaMinute);
        
        long prevTrans = CHICAGO.previousTransition(fallAmbig.getMillis());
        System.out.println("Trans: " + new DateTime(prevTrans, CHICAGO));
        System.out.println("Trans: " + new DateTime(prevTrans + 1, CHICAGO));
        
        
//        DateTime fallAmbig = new DateTime("2007-11-04T01:59:59-06:00");
//
//        System.out.println("Rounding down minute of hour: America/Chicago");
//        DateTime americaHour = fallAmbig.minuteOfHour().roundFloorCopy();
//        System.out.println("Original: " + fallAmbig.withZone(CHICAGO));
//        System.out.println("New: " + americaHour.withZone(CHICAGO));
//
//        System.out.println("Rounding down minute of day: America/Chicago");
//        DateTime americaMinute = fallAmbig.minuteOfDay().roundFloorCopy();
//        System.out.println("Original: " + fallAmbig.withZone(CHICAGO));
//        System.out.println("New: " + americaMinute.withZone(CHICAGO));
//        
//        long prevTrans = CHICAGO.previousTransition(fallAmbig.getMillis());
//        System.out.println("Trans: " + new DateTime(prevTrans, CHICAGO));
//        System.out.println("Trans: " + new DateTime(prevTrans + 1, CHICAGO));
        
        
//        DateTime start = new DateTime(1800, 1, 1, 0, 0, 0, 0, DateTimeZone.UTC);
//        DateTime end = new DateTime(2020, 1, 1, 0, 0, 0, 0, DateTimeZone.UTC);
//        long startMillis = start.getMillis();
//        long endMillis = end.getMillis();
//        
//        Set set = DateTimeZone.getAvailableIDs();
//        for (Iterator it = set.iterator(); it.hasNext(); ) {
//            String zoneID = (String) it.next();
//            DateTimeZone zone = DateTimeZone.forID(zoneID);
//            System.out.println(zone.getID());
//            
//            long millis = startMillis;
//            long last = Long.MIN_VALUE / 2;
//            while (millis < endMillis) {
//                millis = zone.nextTransition(millis);
//                if (millis == last) {
//                    break;
//                }
//                if (millis - last <= DateTimeConstants.MILLIS_PER_HOUR) {
//                    System.out.println(new DateTime(millis, zone) + " " + zone.getID());
//                }
//                last = millis;
//            }
//        }
//        
//        DateTimeZone zone = DateTimeZone.forID("Antarctica/Rothera");
//        long millis = startMillis;
//        long last = Long.MIN_VALUE;
//        while (millis < endMillis) {
//            millis = zone.nextTransition(millis);
//            if (millis == last) {
//                break;
//            }
//            System.out.println(new DateTime(millis - 1, zone) + " " + zone.getID());
//            System.out.println(new DateTime(millis, zone) + " " + zone.getID());
//            last = millis;
//        }
    }

}
