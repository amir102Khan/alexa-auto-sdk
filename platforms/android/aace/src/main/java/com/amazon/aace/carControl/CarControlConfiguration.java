/*
 * Copyright 2017-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *     http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazon.aace.carControl;

import com.amazon.aace.core.config.EngineConfiguration;
import com.amazon.aace.core.config.StreamConfiguration;

import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * The @c CarControlConfiguration class is a factory interface for creating Alexa configuration objects.
 */
public class CarControlConfiguration {
    /**
     * Factory method used to programmatically generate Local Skill Service configuration data.
     * The data generated by this method is equivalent to providing the following @c JSON
     * values in a configuration file:
     *
     * @code    {.json}
     * {
     *   "carControl":
     *   {
     *     "applianceDatabasePath": "<APPLIANCE_DATABASE_PATH>"
     *   }
     * }
     * @endcode
     *
     * @param [in] applianceDatabasePath The path for CHR database used by the Smart Home Skill.
     */
    static public EngineConfiguration createCarControlConfig( String applianceDatabasePath )
    {
        EngineConfiguration carControlConfig = null;

        try
        {
            JSONObject config = new JSONObject();
            JSONObject carControlElement = new JSONObject();

            carControlElement.put( "applianceDatabasePath", applianceDatabasePath );
            config.put( "carControl", carControlElement );

            String configStr = config.toString();
            InputStream is = new ByteArrayInputStream( configStr.getBytes( StandardCharsets.UTF_8.name() ) );

            carControlConfig = StreamConfiguration.create( is );
        }
        catch( Throwable ex ) {
            ex.printStackTrace();
        }

        return carControlConfig;
    }

};
