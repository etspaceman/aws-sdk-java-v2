/*
 * Copyright 2010-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.regions.providers;

/**
 * AWS Region provider that looks for the region in this order:
 * <ol>
 *   <li>Check the 'aws.region' system property for the region.</li>
 *   <li>Check the 'AWS_REGION' environment variable for the region.</li>
 *   <li>Check the {user.home}/.aws/credentials and {user.home}/.aws/config files for the region.</li>
 *   <li>If running in EC2, check the EC2 metadata service for the region.</li>
 * </ol>
 */
public class DefaultAwsRegionProviderChain extends AwsRegionProviderChain {

    public DefaultAwsRegionProviderChain() {
        super(new SystemSettingsRegionProvider(), new AwsProfileRegionProvider(),
              new InstanceProfileRegionProvider());
    }
}