public class StringCaseChanger implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        StringBuilder changed = new StringBuilder();
        for( int i = 0; i < drink.getText().length(); i++){
            if(Character.isLowerCase(drink.getText().charAt(i)))
                changed.append(Character.toUpperCase(drink.getText().charAt(i)));
            else changed.append(Character.toLowerCase(drink.getText().charAt(i)));
        }
        drink.setText(changed.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
