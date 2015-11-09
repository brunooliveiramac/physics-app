package physics.com.physics.model;

import java.io.Serializable;


public class Answer implements Serializable {
		
	
		
        private String answer;
        private Long contentId;
        private Long questionId;
        public String getAnswer() {
            return answer;
        }
        public void setAnswer(String answer) {
            this.answer = answer;
        }
        public Long getContentId() {
            return contentId;
        }
        public void setContentId(Long contentId) {
            this.contentId = contentId;
        }
        public Long getQuestionId() {
            return questionId;
        }
        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }


    @Override
    public String toString() {
        return "Resposta: " + answer + "ID Questão: " + questionId + "ID Content: " + contentId ;
    }
}
