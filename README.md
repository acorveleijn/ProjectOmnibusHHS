# Omnibus group 12
## Menu logic
To keep the menu afloat, we've opted to use several recursive loops.
The main menu offers several options that trigger two actions.
### Action A: open separate menu
We open a new menu with each of their logic implementations from this action function. 
Before the end of the function, we provide the option to stay in the current menu (which opens the menu we are currently in) or go back to the main menu.
Once this action is finished, we automatically start action B.
### Action B: open the main menu
We re-open the main menu. This way, we end up with an infinite loop until the user opts to exit the application.

Example: Main menu -> fight menu -> add fights -> stay in menu? -> fight menu -> show fights -> stay in menu? -> main menu

## Gadget menu logic
After the user makes the choice to enter the gadget menu, they get to choose a submenu.
The choice they enter gets them entered into a switch statement where every submenu has a seperate function providing the right functionality.
Implemented options right now are:
- List of gadgets (basic)
- Search
- Exit
- List of gadgets (detailed)

The main difference between the detailed and the basic list of gadgets is that the attributes of the subclass of which the object is, are also displayed.

The list of gadgets that is used across the menu is only provisioned once upon calling the GadgetMenu function, this is to make sure no new objects with the same name are generated.
Further use of the list across this program is just accessing the list named gadgets directly.
## Fight winner logic
Determining the winner of a fight takes in account several parameters
- Total amount of fans
- Total power level

The winner gets determined by rolling random numbers.
If the power level is higher, the team will gain two extra rolls.
The fan count influences the highest value the stronger(power level) team can roll.
This advantage gives the underdog a higher chance of winning.

Nothing beats playing a home game where the crowd goes wild.

### Example:
- Heroes have 20 fans, 30 power level
- Villains have 10 fans, 50 power level

The Heroes get one roll while the villains get three rolls due to their higher power level.
The Heroes can roll a value between 0 and 100.
The villains can roll three times, but they have fewer fans. 
Therefor they can only roll values between 0 - 90 (80 + (20 * (10 / 20 * 100)).

If the heroes roll > 90, they have won by default.
If they roll < 90, the villains get three chances to top that number. If they do, they will win the fight.

## Adjusted power level
During a fight, the power level is a determining factor that increases the odds of winning. Besides the Person's power level, the weapons held by these fierce warriors might also increase their strength. Therefore we've added a separate getter that returns the default power level plus the modifiers that might apply.

