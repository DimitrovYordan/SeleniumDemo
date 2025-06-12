import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Streams {

	public static void main(String[] args) {
		//regular();
		//filter();
		//map();
		collect();
	}
		@Test
		public static void regular() {
			
			ArrayList<String> names = new ArrayList<String>();
			names.add("Banancho");
			names.add("Dancho");
			names.add("Gancho");
			names.add("Bancho");
			names.add("Vancho");
			int count = 0;
			
			for (int i = 0; i < names.size(); i++) {
				
				String curr = names.get(i);
				if (curr.startsWith("B")) {
					count++;
				}
			}

			System.out.println(count);
		}
		
		@Test
		public static void filter() {
			
			ArrayList<String> names = new ArrayList<String>();
			names.add("Banancho");
			names.add("Dancho");
			names.add("Gancho");
			names.add("Bancho");
			names.add("Vancho");
			
			Long count = names.stream().filter(s -> s.startsWith("B")).count();
			System.out.println(count);
			
			Long c = Stream.of("Gancho", "Bancho", "Banancho", "Vancho").filter(s -> {
				s.startsWith("B");
				return true;
			}).count();
			
			System.out.println(c);
			
			//names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
			names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
			
		}

		@Test
		public static void map() {
			
			ArrayList<String> names = new ArrayList<String>();
			names.add("Kanalcho");
			names.add("Dancho");
			names.add("Lamcho");
			names.add("Mancho");
			names.add("Pancho");
			
			Stream.of("Ganchov", "Bancho", "Banancho", "Vancho").filter(s -> s.endsWith("o")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
			
			List<String> names2 = Arrays.asList("Ganchov", "Bancho", "Banancho", "Vancho");
			names2.stream().filter(s -> s.startsWith("B")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
			
			Stream<String> concatStreams = Stream.concat(names.stream(), names2.stream());
			//concatStreams.sorted().forEach(s -> System.out.println(s));
			
			boolean flag = concatStreams.anyMatch(s -> s.equalsIgnoreCase("Lamcho"));
			Assert.assertTrue(flag);
			System.out.println(flag);
			
		}
		
		@Test
		public static void collect() {
			
			List<String> collects = Stream.of("Ganchov", "Bancho", "Banancho", "Vancho").filter(s -> s.endsWith("o")).map(s -> s.toUpperCase())
			.collect(Collectors.toList());
			System.out.println(collects.get(0));
			
			List<Integer> nums = Arrays.asList(3,6,1,9,6,8,9,4,0);
			//nums.stream().distinct().forEach(n -> System.out.println(n));
			List<Integer> num = nums.stream().distinct().sorted().collect(Collectors.toList());
			System.out.println(num.get(3));
			
		}

}
