package seedu.tracker.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.tracker.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.tracker.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.tracker.testutil.Assert.assertThrows;
import static seedu.tracker.testutil.TypicalIndexes.INDEX_FIRST_MODULE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.tracker.logic.commands.AddCommand;
import seedu.tracker.logic.commands.ClearCommand;
import seedu.tracker.logic.commands.DeleteCommand;
import seedu.tracker.logic.commands.ExitCommand;
import seedu.tracker.logic.commands.HelpCommand;
import seedu.tracker.logic.commands.ListCommand;
import seedu.tracker.logic.parser.exceptions.ParseException;
import seedu.tracker.model.module.Module;
import seedu.tracker.testutil.ModuleBuilder;
import seedu.tracker.testutil.ModuleUtil;

public class ModuleTrackerParserTest {

    private final ModuleTrackerParser parser = new ModuleTrackerParser();

    @Test
    public void parseCommand_add() throws Exception {
        Module module = new ModuleBuilder().build();
        AddCommand command = (AddCommand) parser.parseCommand(ModuleUtil.getAddCommand(module));
        assertEquals(new AddCommand(module), command);
    }

    @Test
    public void parseCommand_clear() throws Exception {
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD) instanceof ClearCommand);
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD + " 3") instanceof ClearCommand);
    }

    @Test
    public void parseCommand_delete() throws Exception {
        DeleteCommand command = (DeleteCommand) parser.parseCommand(
                DeleteCommand.COMMAND_WORD + " " + INDEX_FIRST_MODULE.getOneBased());
        assertEquals(new DeleteCommand(INDEX_FIRST_MODULE), command);
    }

    @Test
    public void parseCommand_exit() throws Exception {
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD) instanceof ExitCommand);
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD + " 3") instanceof ExitCommand);
    }

    @Test
    public void parseCommand_help() throws Exception {
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD) instanceof HelpCommand);
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3") instanceof HelpCommand);
    }

    @Test
    public void parseCommand_list() throws Exception {
        assertTrue(parser.parseCommand(ListCommand.COMMAND_WORD) instanceof ListCommand);
        assertTrue(parser.parseCommand(ListCommand.COMMAND_WORD + " 3") instanceof ListCommand);
    }

    @Test
    public void parseCommand_unrecognisedInput_throwsParseException() {
        assertThrows(ParseException.class, String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE), ()
                -> parser.parseCommand(""));
    }

    @Test
    public void parseCommand_unknownCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parseCommand("unknownCommand"));
    }
}