/*
 * Copyright 2022-2023 the original author or authors.
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
package org.instancio.internal.generator;

import org.instancio.Random;
import org.instancio.documentation.InternalApi;
import org.instancio.generator.Generator;
import org.instancio.generator.GeneratorContext;
import org.instancio.generator.Hints;
import org.instancio.generator.specs.NullableGeneratorSpec;
import org.instancio.internal.util.Constants;

/**
 * Base class for all internal generators.
 *
 * @param <T> type generated by this generator
 */
@InternalApi
public abstract class AbstractGenerator<T> implements Generator<T>, NullableGeneratorSpec<T> {

    private final GeneratorContext context;
    private boolean nullable;

    protected AbstractGenerator(final GeneratorContext context) {
        this.context = context;
    }

    /**
     * Returns the public API method name of the generator spec.
     * The returned name is used for reporting validation errors.
     *
     * @return spec name if defined, or {@code null} otherwise
     */
    public abstract String apiMethod();

    /**
     * Makes the best effort to return a non-null value.
     * However, in certain cases this method will produce a {@code null}.
     *
     * @param random for generating the value
     * @return generated value, either a null or non-null
     */
    protected abstract T tryGenerateNonNull(Random random);

    /**
     * Base implementation that handles nullable values.
     *
     * @param random generating random the value
     * @return generated value, either a null or non-null
     */
    @Override
    public T generate(final Random random) {
        return random.diceRoll(isNullable()) ? null : tryGenerateNonNull(random);
    }

    @Override
    public NullableGeneratorSpec<T> nullable() {
        nullable = true;
        return this;
    }

    public NullableGeneratorSpec<T> nullable(final boolean isNullable) {
        nullable = isNullable;
        return this;
    }

    public final boolean isNullable() {
        return nullable;
    }

    public GeneratorContext getContext() {
        return context;
    }

    @Override
    public Hints hints() {
        // Default for internal generators since most generated types
        // are "value types" that don't have fields that need to be populated.
        return Constants.DO_NOT_MODIFY_HINT;
    }
}
