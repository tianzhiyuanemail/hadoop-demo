package com.example.test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class T {

    public static void main(String[] args) {

        String a = "1050445392945046961,1125355293000374098,1247060547391295908,1289425850907785518,1300925494493799127,1302032991650608113,1305412119816013625,1306418251579228582,1306574665111090725,1307272901258464043,130838699373448385,1324891118354480167,1326142338964007717,1330152546866223333,133626294539796481,1336817698188826496,1337283692324067447,1337967566151035026,1340084970283676275,1344158060053486572,1344784490010782380,1344933164619018725,1347375613445330026,1349849032391924804,1350999211254890966,1355315336873712126,1355798804381151939,1357139504001596111,1358582274211904080,1359274669249771656,1360270287121612193,1360615528933070506,136358975301149295,1371374613936591498,1375684594187079480,1376576751737631334,1380114250905778212,1380464755659620487,138143010664762049,1385198646796755473,1389004613881362013,1389387543954857185,1389756374633817479,1390515961993707490,1393962939477754635,1394546556854303690,1396124016777587532,1397679440859788074,1398843154277415439,1647929615011755053,1790661362294621931,1967293719951196344,2302089529234948424,2427111410159879723,3064399144157453856,322714753994143539,3345901082145427005,3360976246109029567,3425282433965776565,4109135295504792748,4223778040383779238,4230590274183745207,4924978022930773247,510917165308732060,5916399964025869456,5924026765418470147,6440929671130215582,6925072344988942493,744523712210364286,7681023359942508124,7726103432842975236,781824853499930332,7861489422378793622,8300874777590429584,8419822025774437827,8478795065054773046,86204428361203434,8691770082019055594,8949895218838098695,9140869682791965264";
        String b = "1307272901258464043,510917165308732060,1647929615011755053,1357139504001596111,9140869682791965264,8949895218838098695,138143010664762049,1376576751737631334,1358582274211904080,1390515961993707490,4230590274183745207,1394546556854303690,3064399144157453856,1371374613936591498,1289425850907785518,1340084970283676275,1300925494493799127,1336817698188826496,6440929671130215582,781824853499930332,1389756374633817479,5916399964025869456,744523712210364286,1380114250905778212,1790661362294621931,1380464755659620487,1347375613445330026,1389004613881362013,2427111410159879723,1375684594187079480,4223778040383779238,1380382560477442808,8478795065054773046,1967293719951196344,1397679440859788074,4109135295504792748,1337283692324067447,1355315336873712126,1355798804381151939,1344933164619018725,8691770082019055594,1389387543954857185,322714753994143539,5924026765418470147,7861489422378793622,1398843154277415439,1396124016777587532,3360976246109029567,1305412119816013625,133626294539796481,3345901082145427005,8419822025774437827,1326142338964007717,1378019010517625319,136358975301149295,1344158060053486572,7726103432842975236,1306418251579228582,1344784490010782380,1302032991650608113,1337967566151035026,1324891118354480167,1349849032391924804,7681023359942508124,1339703153580505036,1360270287121612193,1360615528933070506,8300874777590429584,1247060547391295908,1385198646796755473,1330152546866223333,1359274669249771656,1350999211254890966,1050445392945046961,86204428361203434,1306574665111090725,1125355293000374098,6925072344988942493,130838699373448385,2302089529234948424,1393962939477754635,4924978022930773247,3425282433965776565,2503086311668762130";


        Set<String> aSet = Arrays.stream(a.split(",")).collect(Collectors.toSet());


        Set<String> bSet = Arrays.stream(b.split(",")).collect(Collectors.toSet());


        Arrays.stream(a.split(","))
                .forEach(o -> {
                    if (!bSet.contains(o)) {
                        System.out.println("a有，b没有=   " + o);
                    }
                });

        Arrays.stream(b.split(","))
                .forEach(o -> {
                    if (!aSet.contains(o)) {
                        System.out.println("b有，a没有=   " + o);
                    }
                });

        long count = Arrays.stream(b.split(","))
                .filter(o -> aSet.contains(o)).map(o -> {
                    System.out.println("ab都有=   " + o);
                    return o;
                }).count();
        System.out.println("ab都有条数=   " + count);


    }


}