interface Chatbot {

    // run the chat, implement the functions to receive and answer chat from users
    void chat();
    // print the transcript of the conversation
    void printTranscript();
    // generate mirrored or canned responses base on the user input
    String respond(String inputString); 
    
}
