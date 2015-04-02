package maman11;

/**
 * Hold X and Y coordinates.
 * @author Angel
 *
 */
public class Position {

		private int _x;
		private int _y;
		
		public Position(int x, int y){
			this.set_y(y);
			this.set_x(x);
		}

		public int get_x() {
			return _x;
		}

		public void set_x(int _x) {
			this._x = _x;
		}

		public int get_y() {
			return _y;
		}

		public void set_y(int _y) {
			this._y = _y;
		}
		
		
}
