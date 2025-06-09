public record Range(int from, int to) {
	// A compact constructor
	public Range {
		if (from > to) {// Swap the bounds
			int temp = from;
			from = to;
			to = temp;
		}
	}
}
