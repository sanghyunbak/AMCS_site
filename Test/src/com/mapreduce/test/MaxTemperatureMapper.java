package com.mapreduce.test;

import java.io.IOException;

import org.apache.hadoop.mapred.lib.HashPartitioner;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MaxTemperatureMapper extends MapReduceBase
	implements Mapper<LongWritable, Text, Text, IntWritable>{
	//Mapper<input Key, input Value, output Key, output value>
	private static final int MISSING = 9999;
	
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
	throws IOException{
		
		String line = value.toString();
		String year = line.substring(1, 5); // 원본 파일 형식
		int airTemperature;
		if(line.charAt(5) == '+'){
			airTemperature = Integer.parseInt(line.substring(6, 9));
		}else{
			airTemperature = Integer.parseInt(line.substring(5, 9));
		}
		output.collect(new Text(year), new IntWritable(airTemperature));
		/*String quality = line.substring(92, 93);
		if(airTemperature != MISSING && quality.matches("[01459]")){
			output.collect(new Text(year), new IntWritable(airTemperature));
		}*/
		
		HashPartitioner hp = new HashPartitioner();
	}
}
