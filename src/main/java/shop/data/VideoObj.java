package shop.data;

import shop.data.VideoObj;

/**
 * Implementation of Video interface.
 * @see Data
 */
final class VideoObj implements Video {
  private final String _title;
  private final int    _year;
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if object invariant violated.
   */
  VideoObj(String title, int year, String director) {
    _title = title;
    _director = director;
    _year = year;
  }

  public String director() {
    // TODO  
    return _director;
  }

  public String title() {
    // TODO  
    return _title;
  }

  public int year() {
    // TODO  
    return _year;
  }

  public boolean equals(Object thatObject) {
    // TODO  
	  if (!(thatObject instanceof VideoObj)) {
			return false;
	  }
		// Cast onto object
		VideoObj Obj = (VideoObj) thatObject;

		return Obj._director.equals(_director) && Obj._title.equals(_title) && Obj._year == _year;

  }

  public int hashCode() {
    // TODO  
	  int result = 17;
	  result = 37 * result + _title.hashCode();
	  result = 37 * result + (int)_year;
	  result = 37 * result + _director.hashCode();
	
    return result;
  }

  public int compareTo(Object thatObject) {
    // TODO  
	  if (thatObject == null)
			throw new NullPointerException();
	  if (!(thatObject instanceof VideoObj)) {
			throw new ClassCastException();
		}
		VideoObj vid = (VideoObj)thatObject;
		
		int dircmp = this._director.compareTo(vid._director);
		if(dircmp > 0) {
			return 1;
		}
		else if (dircmp < 0) { return -1;}
		
		int titlecmp = this._title.compareTo(vid._title);
		if(titlecmp > 0) {
			return 1;
		}
		else if (titlecmp < 0) { return -1;}
		
		if(this._year > vid._year) {
			return 1;
		}
		else if (this._year < vid._year) { return -1;}
    return 0;
  }

  public String toString() {
    // TODO  
    return _title + " ("+ _year +") : " + _director;
  }
}
