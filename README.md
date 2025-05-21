U17A2-appdev
============

## Designing and development of a mobile app

###### BTEC L3 Y3 U17A2

###### This repository has no attached license as it is produced as part of a qualification.

___

## Index:

1. [Context](#context)
    - [Brief](#brief)
2. [Design](#design)
    - [Justification](#justification)
3. [Review](#review)
    - [Optimisations](#optimisations)
    - [Testing](#testing)

___

## Context:

You have been contacted by a local wellness spa and gym. They know you have completed a lot of research on mobile
applications previously and have seen your web article. They want you to create a bespoke habit tracking application.
Their only key requirements are the following:

- Should be able to track the amount of water someone has drunk in a day (Such as counting glasses of water drunk or
  litres etc)
- Should be able to track the number of workouts
- Should have a timer that can be used during workouts.

Please note you do not have to save this information - The app just needs to have the functionality to display / run the
above.

They are hoping to see your creativity and ideas with what other things you can add to your mobile application.

### Brief:

You will first create a design for the application including user interface designs , use-case diagrams , some pseudo
code etc. There should also be a creative aspect here with consideration of colour schemes and mentioning of other
possible functionality you will or could add to the app additional to the wellness spa’s requirements.

You are now to create the program. It will begin as a prototype so the looks do not have to exactly meet the plan but it
is expected that the key functionality it presents. Therefore your mobile app should be able to do the following:

- Keep track of the amount of water someone has had in a day (User input)
- Be able to track the number of workouts in whichever way you feel would work
- Have some sort of timer that can be used to time workouts
- Has multiple screens **OR** One other creative function that would be suitable for a wellness gym / spa ( This is
  where you can show your creativity here)

Once you have completed the program you now need to evaluate the design and optimised mobile app against client
requirements. Along with this it is also the time that you can evaluate yourself and how well you worked during this
project.

You also need to reference how you have demonstrated individual responsibility, creativity and self-management
throughout the previous two tasks.

---

## Design:

My initial design based on the brief given was the simplest application that I felt met the criteria, I was not entirely
sure of how best to track workouts and was concerned about the minimal amount of functional time available for
development due to other commitments that ran parallel to this project. The compromises made can be clearly seen in the
designs' simplicity.

![First design draft](/readme_files/AppDiagram.png)

Despite my concerns, upon submitting my designs for peer review, minimal suggestions were made as to how to improve it,
these were:

- Complaint about icons contacting screen edges.
- The buttons "Back" and "Change Timer" are uncentred and different sizes.
- Lacking colours.

These were all simple enough to rectify in a quick revision seen below.

![Post-peer-review design](/readme_files/AppDiagram2.png)

Accompanying my designs was a use case diagram that explains interaction.

![Use-Case diagram](/readme_files/UseCase.png)

Below is Pseudocode produced for the basic numerical timer.

```
########## when button pressed do ##########
IF <buttonID> IS timer_toggle THEN //Note: change button text
    IF isPaused THEN
        button<timer_toggle> TEXT <- Stop
        button<lap_clear> TEXT <- Lap
    ELSE THEN
        button<timer_toggle> TEXT <- Start
        button<lap_clear> TEXT <- Clear
    END IF
    isPaused <- NOT isPaused
ELSE IF <buttonID> IS lap_clear THEN //Note: lap and clear function
    IF isPaused THEN    //Note: clear
        count <- 0.0
        CLEAR laps_done
        HIDE laps_done
    ELSE THEN           //Note: lap    
        SHOW laps_done
        APPEND laps_done <- count - last_lap
        last_lap <- count
    END IF
END IF

########## timer function ##########
WHILE NOT isPaused DO
    count <- count + 0.01
    WAIT 10 MILLISECONDS 
END WHILE
```

### Justification:

The brief provided by the wellness spa and gym has requested that I include within my app a timer and have the ability
to track water consumed and workouts. This has been implemented within my bare-bones design spanning 4 pages in the form
of 2 variant timers, a counter indicating water consumption and a calculator for identifying cumulative calories burned
during several workouts. They have also asked that creativity be expressed in my design which has been achieved via the
inclusion of alternate timers. In terms of colour schemes, I have chosen to stick with the default purple and white of
android studio. The contacting company has provided little information about themselves, and this decision will be
changed after establishing their branding and styling. An application should be representative of the company who own it
in order to strengthen brand image, and -without full knowledge of the companies image- it is not possible for me to
adequately achieve this. The overall layout is the minimal necessary complexity, this was done due to the prototype
nature of the application, more representative design is something that should be communicated with a qualified UX
designer and representation from the commissioning company. I have chosen to include individual laps below the timer,
despite this not being requested within the brief, in order to improve readability and functionality of the application.
By doing this, timer users will be able to easily move minute times from the timer to the workouts page after a workout
and without needing to stop. The water counter design utilising 6 buttons and entry field was chosen as the values
assigned to 5 of the buttons cover some of the most common drinking glass capacities. The 6th button and entry field are
included as an alternative to listing every possible glass capacity.

---

## Review:

Having completed the mobile app prototype, I believe that I have met or near met all requirements set out by the
commissioning party. Those being:

- Produce a prototype app that:
    - Tracks water consumed within a day.
    - Tracks the number of workouts done in a way of my choosing
    - Contains a timer
    - Has multiple screens

The brief also specifies that the applications does not have to entirely meet my designs.  
There are some minor issues with my fitness tracking app such as:

- basic colour palette

The colours I chose to use within my design and app were just the standard purple and white that come in android studio
despite changing them being trivial. This was done due to the lack of information about the company requesting
development given. The app can easily be tweaked to have an improved palette.

- workout tracking implementation

The brief states specifically that the app should track number of workouts done, I took a parallel approach to this -
instead opting to calculate the cumulative calories burnt during multiple workouts. Should explicit tracking of workouts
be insisted on, this can be done by adding a simple counter that increases every time a new workout is submitted. This
approach could also include an output showing approximate calories per workout submitted today.

With both of those in mind, I still believe my prototype fitness tracking app to have met the criteria set.

### Optimisations:

Optimisations were made at several points during development to improve functionality in several areas.

- In [commit cde211e](https://github.com/TheVeryCoolDog/U17A2-appdev/commit/cde211ef7a4bc57950dfe3f0fdcd544b22000215):
    - Optimised setting listeners.
        - In file "TimerNumerical.java" replaced line 36-39 compactin listener assignment into loop. This became the
          default method in all further additions.
    - Removed un-needed imports.
        - In files Menu.java on line 11 and TimerNumerical on line 3.
    - Adjusted page titles to have unique IDs.
        - In files "Menu.xml", "timer_numerical.xml", "timer_visual.xml", "water.xml", and "workouts.xml".
- In [commit 2634023](https://github.com/TheVeryCoolDog/U17A2-appdev/commit/2634023d8511a64ff8a26f17c90aeaa0fc28d03c):
    - Replaced anonymous runnable with lambda.
        - In file "TimerNumerical.java" replaced lines 49-51 with "runOnUiThread(() -> {".
    - Converted classes to primitives where possible.
        - In files "TimerNumerical.java" on line 23, "Water.java" on line 26. This became the default method in all
          further additions.
- In [commit 8980128](https://github.com/TheVeryCoolDog/U17A2-appdev/commit/8980128a6e1e8d71c5ca908f18f478f838cb9410):
    - Improved timer readout.
        - In file "TimerNumerical.java" line 52 was replaced with ""%1\$02.0f:%2\$05.2f", floor(count/60)%60,
          count%60));",  
          and in file "strings.xml" "\<string name="timer_default">0.00 seconds\</string>" was replaced
          with \<string name="timer_default">00:00.00\</string>. These changes convert the timer from seconds to a
          standard 00:00.00 format.

### Testing:

<sub>

Note: testing was completed on emulators (Android Medium Phone and Google Pixel 5 with hardware acceleration)

Note: testing is accurate as
of [commit 6ea3ef9](https://github.com/TheVeryCoolDog/U17A2-appdev/commit/6ea3ef9527a330df6721adc7d13c505a74a9eee4)

Note: TimerVisual was excluded from most appropriate tests as it was not fully implemented

</sub>

| Test | Purpose                                                     | Method                                                                                                                          | Expected                                                    |       Actual        |  
|:----:|:------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------------|:------------------------------------------------------------|:-------------------:|
|  1   | Check menu button "Timer"                                   | Pressing button "Timer"                                                                                                         | Opens page "TimerNumerical"                                 |     As expected     |
|  2   | Check menu button "Workouts"                                | Pressing button "Workouts"                                                                                                      | Opens page "Workouts"                                       |     As expected     |
|  3   | Check menu button "Water"                                   | Pressing button "Water"                                                                                                         | Opens page "Water"                                          |     As expected     |
|  4   | Check "Change Timer" button on page "TimerNumerical/Visual" | Pressing button "ChangeTimer" on both pages                                                                                     | Switches between pages "TimerNumerical" and "TimerVisual"   |     As expected     |
|  5   | Check "Back" button on page "TimerNumerical"                | Pressing button "Back"                                                                                                          | Returns to page "Menu"                                      |     As expected     |
|  6   | Check "Back" button on page "TimerVisual"                   | Pressing button "Back"                                                                                                          | Returns to page "Menu"                                      |     As expected     |
|  7   | Check "Back" button on page "Workouts"                      | Pressing button "Back"                                                                                                          | Returns to page "Menu"                                      |     As expected     |
|  8   | Check "Back" button on page "Water"                         | Pressing button "Back"                                                                                                          | Returns to page "Menu"                                      |     As expected     |
|  9   | Check Timer(Numerical) "Start" button                       | Pressing button "Start"                                                                                                         | "Start" becomes "Stop", "Clear" becomes "Lap", timer starts |     As expected     |
|  10  | Check Timer(Numerical) "Stop" button                        | Pressing button "Stop"                                                                                                          | "Stop" becomes "Start", "Lap" becomes "Clear", timer stops  |     As expected     |
|  11  | Check Timer(Numerical) "Lap" button                         | Pressing button "Lap"                                                                                                           | Lap time (dif between last and current) appears below       | Shows current$^{*}$ |
|  12  | Check Timer(Numerical) "Clear" button                       | Pressing button "Clear"                                                                                                         | Timer resets to 00:00.00 and stored laps are removed        |     As expected     |
|  13  | Check Water volume buttons                                  | Pressing each button with an assigned value                                                                                     | Total is incremented by button label's volume in ml         |     As expected     |
|  14  | Check "ml?" entry field restriction                         | Attempting to type non-int with external kb                                                                                     | No characters appear                                        |     As expected     |
|  15  | Check custom Water volume                                   | Pressing "Submit" button                                                                                                        | Custom value is added to water drank                        |     As expected     |
|  16  | Check weight entry field restriction                        | Attempting to type non-double with external kb                                                                                  | No characters appear                                        |     As expected     |
|  17  | Check MET entry field restriction                           | Attempting to type non-double with external kb                                                                                  | No characters appear                                        |     As expected     |
|  18  | Check Minute entry field restriction                        | Attempting to type non-int with external kb                                                                                     | No characters appear                                        |     As expected     |
|  19  | Check MET calculation accuracy                              | Entering values: 77.3kg, 11.5METS, 45 Minutes[$^{[value-source]}$](https://blog.nasm.org/metabolic-equivalents-for-weight-loss) | 700.00 Kcal burned                                          |    700.05$^{**}$    |

<sub>

*fixed
in [commit 35e2dad](https://github.com/TheVeryCoolDog/U17A2-appdev/commit/35e2dad08bc809c00884514cbff56c9ce8dfbf80)

**not altered, ignore rounding

</sub>

---