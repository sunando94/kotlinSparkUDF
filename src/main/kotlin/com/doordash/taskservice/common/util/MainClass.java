package com.doordash.taskservice.common.util;

import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.types.DataTypes.StringType;

public class MainClass {
    public static void main(String[] args) {
        SparkSession spark = new SparkSession.Builder().master("local[*]").appName("app").getOrCreate();
        TranslatorUdf7 translatorUdf5 = new TranslatorUdf7();
        spark.udf().register("myudf11", translatorUdf5,StringType);
        spark.sql("SELECT myudf11(1) ").show(10);

    }
}
