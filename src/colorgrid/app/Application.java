package colorgrid.app;

import java.util.HashMap;

import colorgrid.service.ColorGridService;

public class Application {
	public static void main(String[] args) {
		
		HashMap<Integer,String > colors = new HashMap<>();
		colors.put(1, "RED");
		colors.put(2, "BLUE");
		colors.put(3, "GRAY");
		ColorGridService service = new ColorGridService(colors);
		
		int[][] input = { { 2, 2, 3, 2, 2, 1, 1, 2, 1, 2 }, { 2, 1, 1, 1, 3, 1, 1, 1, 3, 2 },
				{ 3, 3, 3, 3, 1, 3, 1, 3, 3, 3 }, { 3, 3, 3, 2, 3, 2, 2, 2, 1, 3 }, { 2, 2, 2, 1, 3, 1, 2, 1, 3, 1 },
				{ 1, 2, 2, 1, 1, 2, 2, 1, 3, 1 }, { 1, 3, 2, 1, 2, 1, 3, 2, 2, 2 }, { 2, 3, 1, 1, 1, 1, 2, 2, 1, 1 },
				{ 1, 1, 3, 2, 3, 3, 2, 1, 1, 3 }, { 1, 2, 2, 2, 2, 2, 1, 2, 2, 3 }, { 2, 1, 2, 2, 1, 2, 2, 2, 1, 1 },
				{ 2, 1, 2, 2, 3, 2, 2, 2, 3, 1 } };
		
		String result = service.computeLargestConnectedGrid(input);
		System.out.print(result);
	}

	
}
