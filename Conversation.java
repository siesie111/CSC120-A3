import java.util.*;

class Conversation implements Chatbot {

  // Attributes 
  // an arraylist of transcript that applies to each individual conversation object
  List<String> transcript = new ArrayList<>();
  // an arraylist of canned responses that applies to the entire Conversation class
  static List<String> cannedResponse = new ArrayList<>();
  // a hashmap (dictionary) of mirrored responses that applies to the entire Conversation class
  static HashMap<String, String> mirroredResponse = new HashMap<>();
  
  // adding some canned response
  static{
    cannedResponse.add("Mmm-hm.");
    cannedResponse.add("Wooo that's interesting!");
    cannedResponse.add("Happy to hear that.");
    cannedResponse.add("Yes I understand.");
    cannedResponse.add("Absolutely.");
  }
  
  // adding some mirrored response 
  static{
    mirroredResponse.put("I", "you");
    mirroredResponse.put("me", "you");
    mirroredResponse.put("am", "are");
    mirroredResponse.put("you", "I");
    mirroredResponse.put("my", "your");
    mirroredResponse.put("your", "my");
  }

  /**
   * Constructor 
   */
  Conversation() {

  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
  
    // ask the user to input round number and store it 
    System.out.println("How many rounds?");
    Scanner input = new Scanner (System.in);
    int round = input.nextInt();

    // print the greeting and add it to the transcript
    System.out.println("Hi there!  What's on your mind?");
    transcript.add("Hi there!  What's on your mind?");

    // chat with the user according to the round number, and store the conversation to the transcript
    for (int i = 0; i <= round; i++){
      // get the user input using the input object created earlier and add it to the transcript
      String userInput = input.nextLine();
      transcript.add(userInput);
      // get the charbox response from the respond function, print it and store to the transcript
      String response = respond(userInput);
      System.out.println(response);
      transcript.add(response);
    }

    // end the conversation and add it to the transcript
    System.out.println("See ya!");
    transcript.add("See ya!");
    
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    // using the for-each loop to print each line of the transcript with the header "TRANSCRIPT: "
    System.out.println("TRANSCRIPT: ");
    for (String transcripts: transcript){
      System.out.println(transcripts);
    }
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
      * @param userInput 
      * @return mirrored or canned response to user input  
      */
  public String respond(String userInput) {
    // split the user input sentence into strings using split function
    String[] elements = userInput.split(" ");
    boolean mirror = false;
    // loop the string list to find the corresponding index
    for (int i = 0; i < elements.length; i++){
      // if the user input contains mirrored words, return the mirrored response by replacing the word
      if (mirroredResponse.containsKey(elements[i])){
        elements[i] = mirroredResponse.get(elements[i]);
        // set the boolean to true if the corresponding index exist
        mirror = true;
      }
    }
    // use the mirrored response if the boolean is true
    if (mirror){
    String result = String.join(" ", elements);
    return result;
    }
    // use the canned response if can't use mirrored response
    else {
    Random random = new Random();
    int num = random.nextInt(cannedResponse.size());
    String result = cannedResponse.get(num);
    return result;
    }
  }

  @Override
  public String toString() {
    return "Conversation [transcript=" + transcript + "]";
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
