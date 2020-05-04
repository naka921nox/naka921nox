package jp.interpreter;

import java.util.ArrayList;

// <commnad list> ::= <command>* end
public class CommnadListNode extends Node {
    private ArrayList<Node> list = new ArrayList<>();

    @Override
    public void parse(Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing end");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                Node commnadNode = new CommandNode();
                commnadNode.parse(context);
                list.add(commnadNode);
            }
        }
    }
    
}