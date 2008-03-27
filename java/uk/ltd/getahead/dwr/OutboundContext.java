package uk.ltd.getahead.dwr;

import java.util.HashMap;
import java.util.Map;

/**
 * We need to keep track of stuff while we are converting on the way out to
 * prevent recurrsion.
 * This class helps track the conversion process.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public final class OutboundContext
{
    /**
     * The prefix for outbound variable names the we generate
     */
    public static final String OUTBOUND_VARIABLE_PREFIX = "s"; //$NON-NLS-1$

    /**
     * Have we already converted an object?
     * @param object The object to check
     * @return How it was converted last time or null if we've not seen it before
     */
    public OutboundVariable get(Object object)
    {
        return (OutboundVariable) map.get(object);
    }

    /**
     * @param object We have converted a new object, remember it
     * @param ss How the object was converted
     */
    public void put(Object object, OutboundVariable ss)
    {
        map.put(object, ss);
    }

    /**
     * Create a new variable name to keep everything we declare separate
     * @return A new unique variable name
     */
    public String getNextVariableName()
    {
        String varName = OUTBOUND_VARIABLE_PREFIX + nextVarIndex;
        nextVarIndex++;

        return varName;
    }

    /**
     * The map of objects to how we converted them last time
     */
    private final Map map = new HashMap();

    /**
     * What index do we tack on the next variable name that we generate
     */
    private int nextVarIndex = 0;
}
