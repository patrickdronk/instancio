/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.instancio.generators;

import org.instancio.GeneratorContext;
import org.instancio.generators.coretypes.AbstractRandomNumberGeneratorSpec;
import org.instancio.generators.coretypes.NumberGeneratorSpec;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerGenerator extends AbstractRandomNumberGeneratorSpec<AtomicInteger> implements NumberGeneratorSpec<AtomicInteger> {

    private static final int DEFAULT_MIN = 1;
    private static final int DEFAULT_MAX = 10_000;

    public AtomicIntegerGenerator(final GeneratorContext context) {
        super(context,
                new AtomicInteger(DEFAULT_MIN),
                new AtomicInteger(DEFAULT_MAX),
                false);
    }

    public AtomicIntegerGenerator(final GeneratorContext context, final int min, final int max, final boolean nullable) {
        super(context, new AtomicInteger(min), new AtomicInteger(max), nullable);
    }

    @Override
    protected AtomicInteger generateNonNullValue() {
        return new AtomicInteger(random().intBetween(min.intValue(), max.intValue()));
    }
}
