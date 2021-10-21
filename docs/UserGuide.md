---
layout: page
title: User Guide
---

NUS Mod Tracker is a **desktop app** for **NUS Computer Science (CS) students** to **manage their modules and track their course completion.**
It is optimized for use via a Command Line Interface (CLI), while still having the benefits of a Graphical User 
Interface (GUI).

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `modtracker.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your Mod Tracker.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all modules.

   * `add c/CS2103T t/Software Engineering d/Covers the main areas of software development n/4 tag/core` : Adds a module named `CS2103T` to the Mod Tracker.

   * **`delete`**`3` : Deletes the 3rd module shown in the current list.


1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add m/MODULE`, `MODULE` is a parameter which can be used as `add m/GEQ1000`.

* Items in square brackets are optional.<br>
  e.g. `c/CODE [tag/TAG]` can be used as `c/CS2103T tag/core` or as `c/CS2103T`.
  
* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `m/GEQ1000 m/GEQ1000`, only `m/GEQ1000` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help` [Coming soon]

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Listing current modules: `list`

Shows a list of all modules taken for the current semester.

Format: `list`

### Adding a module: `add`

Adds a module to the module tracker.

Format: `FORMAT: add c/CODE t/TITLE d/DESCRIPTION n/MC [tag/TAG]`
* Commands must follow the specified format, **no fields should be left blank**.
* **MC** must be a **positive integer** (1,2,3...).
* **CODE** must follow the NUSMods module code format.

Examples:
* `add c/CS2103T t/Software Engineering d/Covers the main areas of software development n/4 tag/core`

### Finding a module: `find`

Shows a list of all the modules that contains the given keyword.

Format: `FORMAT: find [c/] [t/] [d/] [n/] [tag/] KEYWORDS`
* **KEYWORDS** refers to the words that the application will search the modules by.
* If no optional parameters are entered, the application will search within all the modules'
  components for matching **KEYWORDS**
* If optional parameters are entered, the application will search within the modules'
  specified components for matching **KEYWORDS**

Examples:
* `find CS` displays any modules that contain the word "CS" in the code, title, description, mc or tag.
* `find c/ t/ CS GE` displays any modules that contain the words "CS" or "GE" in the code or title.
* `find c/ CS2040S` displays any modules that contain the word "CS2040S" in the code.
* `find tag/ UE` displays any modules that contain the word "UE" in the tag.


### Editing a module : `edit'


Edits an existing module in the mod tracker.

Format: `edit INDEX [c/CODE] [t/TITLE] [d/Description] [n/MC] [tag/TAG]`

* At least one of the optional fields must be provided.
* The given value for the field must be different from the original one.
* The given value for `CODE` field must not be duplicated with existing `CODE`
* The INDEX refers to the index number shown in the displayed module list.
* The INDEX must be a positive integer (1, 2, 3 ...).

Examples:
* `edit 2 c/CS2103T t/Software Engineering` Edits the code and title of the 1st module to be CS2103T and Software Engineering respectively.
* `edit 3 n/2` Edits the MC for the 3rd module to be 2.

### Deleting a module : `delete`

Deletes a module from the module tracker

Format: `delete INDEX`

* Deletes a module at the specified `INDEX`.
* The index refers to the index number shown in the displayed module list.
* The index **must be a positive integer** 1, 2, 3, …​

Example:
* `delete 2` deletes the 2nd module in the module tracker.


### Taking a module : `take`

Take a module in the specified semester.

Format: `take INDEX y/YEAR s/SEMESTER`

* Schedules the module at the specified `INDEX` for the specified `YEAR` and `SEMESTER`.
* If the specified module has already been scheduled, its schedule will be overridden.
* The `INDEX` refers to the index number shown in the displayed module list.
* The `INDEX` **must be a positive integer** (1, 2, 3 ...).
* The `YEAR` must be a positive integer from 1-6.
* The `SEMESTER` must be a positive integer from 1-4.
* Special semesters 1 and 2 are represented by integer values 3 and 4 respectively (see examples below).

Example:
* `take 2 y/2 s/1` schedules the 2nd module in the module tracker for year 2 semester 1.
* `take 1 y/1 s/3` schedules the 1st module in the module tracker for year 1 special semester 1.
* `take 1 y/1 s/4` schedules the 1st module in the module tracker for year 1 special semester 2.


### Remove the schedule from ("untake") a module : `untake`

Remove the schedule from a module in the module tracker.

Format: `untake INDEX`

* Removes the schedule from the module at the specified `INDEX`.
* The `INDEX` refers to the index number shown in the displayed module list.
* The `INDEX` **must be a positive integer** (1, 2, 3 ...).

Example:
* `untake 1` removes the schedule from the 1st module in the module tracker.

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add c/CODE t/TITLE d/DESCRIPTION n/MC [tag/TAG]` <br> e.g. `add c/ST2334 t/Probability and Statistics d/Introduces students to basic probability theory and statistical inference n/4`
**Delete** | `delete INDEX`<br> e.g. `delete 3`
**Edit** | `edit INDEX [c/CODE] [t/TITLE] [d/Description] [n/MC] [tag/TAG]` <br> e.g. `edit 2 c/CS2103T t/Software Engineering`
**Find** | `find [code] [title] [description] [mc] [tag] KEYWORDS` <br> e.g. `find code CS2040S`
**List** | `list`
**Take** | `take INDEX y/YEAR s/SEMESTER` <br> e.g. `take 2 y/2 s/1`
**Untake** | `untake INDEX` <br> e.g. `untake 1`
**Help** [Coming soon] | `help`
