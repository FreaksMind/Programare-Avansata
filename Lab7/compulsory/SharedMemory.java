package lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SharedMemory {
	private final List<Token> tokens = new ArrayList<>();
	private boolean vizited;

	public SharedMemory(int n) {
		for(int i = 0; i < n; ++i) {
			tokens.add(new Token(i));
		}
		Collections.shuffle(tokens);
	}

	public boolean isVisited() {
		return vizited;
	}

	public void setVisited(boolean visited) {
		vizited = visited;
	}

	public void addTokens(List<Token> list) {
		for (int i = 0; i < list.size(); ++i) {
			tokens.add(list.get(i));
		}
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public synchronized List<Token> extractTokens(int howMany) {
		List<Token> extracted = new ArrayList<>();
		for (int i = 0; i < howMany; i++) {
			if (tokens.isEmpty()) {
				break;
			}
			int id = (int) (Math.random() % tokens.size() - 1);
			extracted.add(tokens.get(id));
			tokens.remove(id);
		}
		return extracted;
	}
}