package colorgrid.app;

import colorgrid.service.ColorGridService;

public class Application {
	public static void main(String args[]) {
		// Red = 1
		// Blue = 2
		// Gray = 3
		int[][] input = { { 2, 2, 3, 2, 2, 1, 1, 2, 1, 2 }, 
				          { 2, 1, 1, 1, 3, 1, 1, 1, 3, 2 },
				          { 3, 3, 3, 3, 1, 3, 1, 3, 3, 3 }, 
				          { 3, 3, 3, 2, 3, 2, 2, 2, 1, 3 }, 
				          { 2, 2, 2, 1, 3, 1, 2, 1, 3, 1 },
				          { 1, 2, 2, 1, 1, 2, 2, 1, 3, 1 },
				          { 1, 3, 2, 1, 2, 1, 3, 2, 2, 2 },
				          { 2, 3, 1, 1, 1, 1, 2, 2, 1, 1 },
				          { 1, 1, 3, 2, 3, 3, 2, 1, 1, 3 },
				          { 1, 2, 2, 2, 2, 2, 1, 2, 2, 3 },
				          { 2, 1, 2, 2, 1, 2, 2, 2, 1, 1 },
				          { 2, 1, 2, 2, 3, 2, 2, 2, 3, 1 }
				          };
		ColorGridService service = new ColorGridService();
		int result = service.computeLargestConnectedGrid(input);
		switch(result) {
		case 1:
			System.out.println("RED");
			break;
		case 2:
			System.out.println("BLUE");
			break;
		case 3:
			System.out.println("BLACK");
			break;
		}
	}
}
