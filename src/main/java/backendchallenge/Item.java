package backendchallenge;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
	private String question;
	private String answer;
        private String tags;
        
        protected Item() {}
        
        public Item(final String question, final String answer, final String tags) {
            this.question = question;
            this.answer = answer;
            this.tags = tags;
        }

	public String getFirstName() {
		return question;
	}

	public void setFirstName(String question) {
		this.question = question;
	}

	public String getLastName() {
		return answer;
	}

	public void setLastName(String answer) {
		this.answer = answer;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}