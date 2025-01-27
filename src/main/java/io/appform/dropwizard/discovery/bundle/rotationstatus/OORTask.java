/*
 * Copyright (c) 2016 Santanu Sinha <santanu.sinha@gmail.com>
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

package io.appform.dropwizard.discovery.bundle.rotationstatus;

import io.dropwizard.servlets.tasks.Task;
import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Admin task to take node oor in ranger
 */
@Slf4j
public class OORTask extends Task {
    private final RotationStatus rotationStatus;
    public OORTask(RotationStatus rotationStatus) {
        super("ranger-oor");
        this.rotationStatus = rotationStatus;
    }

    @Override
    public void execute(Map<String, List<String>> map, PrintWriter printWriter) {
        rotationStatus.oor();
        log.info("Taking node out of rotation on ranger");
    }
}
