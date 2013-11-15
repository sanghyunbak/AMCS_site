package com.mapreduce.test;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class MaxTemperatureWithCombiner {
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	throws IOException{
		// TODO Auto-generated method stub
		if(args.length != 2){
			System.err.println("Usage: MaxTemperature <input path> <output path>");
			System.exit(-1);
		}
		
		JobConf conf = new JobConf(MaxTemperature.class);
		conf.setJobName("max temperature");
		
		FileInputFormat.addInputPath(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		
		// Map과 Reduce 중간에 Combiner 
		// Combiner는 최적화에만 관련이 있기 때문에 실행 유무에 상관없이 결과는 동일 
		conf.setMapperClass(MaxTemperatureMapper.class);
		conf.setCombinerClass(MaxTemperatureReducer.class);
		conf.setReducerClass(MaxTemperatureReducer.class);
		
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		
		JobClient.runJob(conf);
		
		System.out.println("====================== END COMBINER =====================");
	}

}
