# Line Distribution

## Purpose
**The primary purpose of this program is to equitably distribute lines for play read throughs.** 
Equitable line distribution is not the only intent for this program, however. It also
has options for you to see how many speeches a character has, how many words they speak,
their lines, and similar things. You may do similar studies on the assigned roles for
read throughs. For full capabilities, see below.

## Motivation
I was doing Shakespeare read throughs and soon discovered that it was difficult to 
distribute lines evenly among 5-6 people to do a read through, and still have no
one talk to each other. As a result, I decided to write a program that could equally
distribute characters in a play among a small number of roles. This is *not* designed
for putting on an actual play. There are probably several times where someone plays
characters who are on stage at the same time. It was simply intended to never create
a scenario where people are talking to themselves during a read through.

## Installation
You have to be able to run Java in order for this project to work. After that, download
it I guess. In any files which use the code, put `import classes.*` at the top, if you're
doing it in Java. 

## Usage
### Play File Formatting Specifications
In order to properly use this program, certain formatting is required:
* Character names before a line must be in all caps
* There should *not* be a cast list with the character names in all caps at the beginning
* Any two word character names (for instance FIRST SERVANT) must be underscored (FIRST_SERVANT)
* Any word three letters or longer in all caps will be treated as a character name, so make sure only character names before a line are all capitalized
* I've only tested it for the txt file format, so I don't know if it works for anything else

### Examples
In the "examples" folder you can see almost all of the usages of the methods in 
each class.

### Line Distribution
If you would simply like to receive role distributions and nothing else, then use
the file "AssignRoles.java" in the examples folder. Run this in the command prompt using the 
command `java -jar AssignRoles.jar`, and it'll provide prompts and you can go from there.
When it says "play location", you must put the location from the root. For examples of location
series that work, see the other examples files. It'll then print out role assignments.
*Note: The AssignRoles.java file is only intended to figure out assigning roles and nothing*
*else. If you want a more personalized experience, use the Java classes and methods.*

## Contributing
Opening issues and using pull requests are perfectly welcome.

## License
[MIT](https://choosealicense.com/licenses/mit/)