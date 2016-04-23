/*******************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.intercom.io.flattenarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


/**
 * The Class ArrayFlattener.
 * @author Yasith Lokuge
 */
public class ArrayFlattener {

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(ArrayFlattener.class);
	
    /**
     * Flatten.
     *
     * @param inputArray the input array
     * @return the integer[]
     * @throws IllegalArgumentException the illegal argument exception
     */
    public static Integer[] flatten(Object[] inputArray) throws IllegalArgumentException {
    	
    	BasicConfigurator.configure();
    	
    	logger.info("Executing Input Array");
    	
        if (inputArray == null){
        	logger.info("Null Input Found. Exiting.");        	
        	return null;
        }

        List<Integer> flatList = new ArrayList<Integer>();

        for (Object element : inputArray) {
            if (element instanceof Integer) {
                flatList.add((Integer) element);
            } else if (element instanceof Object[]) {
                flatList.addAll(Arrays.asList(flatten((Object[]) element)));
            } else {
            	logger.error("Input must be an array of Integers or nested arrays of Integers");            	
                throw new IllegalArgumentException("Error: Input must be an array of Integers or nested arrays of Integers");
            }
        }
        logger.info("Input Array has been flattened");
        return flatList.toArray(new Integer[flatList.size()]);
    }
}
