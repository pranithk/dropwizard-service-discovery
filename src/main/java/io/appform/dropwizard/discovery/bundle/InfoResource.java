/*
 * Copyright (c) 2019 Santanu Sinha <santanu.sinha@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.appform.dropwizard.discovery.bundle;

import io.appform.ranger.client.RangerClient;
import io.appform.ranger.common.server.ShardInfo;
import io.appform.ranger.core.finder.serviceregistry.MapBasedServiceRegistry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Given information about the cluster.
 */
@Produces(MediaType.APPLICATION_JSON)
@Path("/instances")
public class InfoResource {
    private final RangerClient<ShardInfo, MapBasedServiceRegistry<ShardInfo>> serviceDiscoveryClient;

    public InfoResource(RangerClient<ShardInfo, MapBasedServiceRegistry<ShardInfo>> serviceDiscoveryClient) {
        this.serviceDiscoveryClient = serviceDiscoveryClient;
    }

    @GET
    public Response get() {
        return Response.ok(serviceDiscoveryClient.getAllNodes()).build();
    }
}
